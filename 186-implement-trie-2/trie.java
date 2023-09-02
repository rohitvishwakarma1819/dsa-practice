import java.util.*;
import java.io.*;

public class Trie {
    Trie[] child;
    int count;

    public Trie() {
        // Write your code here.
        child = new Trie[26];
        count = 0;
    }

    public void insert(String word) {
        // Write your code here.
        Trie trie = this;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (trie.child[c] == null) {
                trie.child[c] = new Trie();
            }
            trie = trie.child[c];
        }
        trie.count++;
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Trie trie = this;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (trie.child[c] == null) {
                return 0;
            }
            trie = trie.child[c];
        }
        return trie.count;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Trie trie = this;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (trie.child[c] == null) {
                return 0;
            }
            trie = trie.child[c];
        }

        Queue<Trie> q = new LinkedList<>();
        q.add(trie);
        int ans = 0;
        while (!q.isEmpty()) {
            Trie node = q.poll();
            ans += node.count;
            for (int i = 0; i < 26; ++i) {
                if (node.child[i] != null) {
                    q.add(node.child[i]);
                }
            }
        }
        return ans;
    }

    public void erase(String word) {
        // Write your code here.
        Trie trie = this;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (trie.child[c] == null) {
                return;
            }
            trie = trie.child[c];
        }
        trie.count--;
    }
}

// T -> Insert, countWordsEqualTo, erase -> O(N)
// T -> countWordsStartingWith -> O(word.length + (sum of prefix words length -
// count of prefix word length * word.length))
// S -> Insert, Search, StartsWith -> O(1)
