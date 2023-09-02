class Trie {
    private Trie[] childs;
    private boolean isEnd;

    public Trie() {
        childs = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (node.childs[index] == null) {
                node.childs[index] = new Trie();
            }
            node = node.childs[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (node.childs[index] == null) {
                return false;
            }
            node = node.childs[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (node.childs[index] == null) {
                return false;
            }
            node = node.childs[index];
        }
        return true;
    }
}

// T -> Insert, Search, StartsWith -> O(N)
// S -> Insert, Search, StartsWith -> O(1)
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
