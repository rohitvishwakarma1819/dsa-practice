class Pair {
    int r, c;

    Pair(int a, int b) {
        r = a;
        c = b;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        Stack<Pair> l = new Stack<>();
        int direction[][] = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int startingColor = image[sr][sc];
        l.push(new Pair(sr, sc));
        while (l.size() > 0) {
            Pair p = l.pop();
            image[p.r][p.c] = newColor;
            for (int i = 0; i < 4; ++i) {
                int newR = p.r + direction[i][0];
                int newC = p.c + direction[i][1];
                if (isValid(newR, newC, image.length, image[0].length)) {
                    if (image[newR][newC] == startingColor) {
                        l.push(new Pair(newR, newC));
                    }
                }
            }
        }
        return image;
    }

    public boolean isValid(int r, int c, int sr, int sc) {
        return (r < sr && r >= 0) && (c < sc && c >= 0);
    }
}