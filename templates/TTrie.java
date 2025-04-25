package templates;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class Trie {
    private final TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insert(String value) {
        TrieNode curr = this.root;
        for (char c : value.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }

    public boolean isExactMatch(String value) {
        return search(value, true);
    }

    public boolean isPrefix(String prefix) {
        return search(prefix, false);
    }

    private boolean search(String value, boolean exactMatch) {
        TrieNode curr = this.root;
        for (char c : value.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr != null && curr.endOfWord == exactMatch;
    }

    public void printValidWords() {
        print("", this.root);
    }

    private void print(String slate, TrieNode node) {
        if (node.endOfWord) {
            System.out.println(slate);
        }

        for (int i = 0; i < node.children.length; i++) {
            TrieNode child = node.children[i];
            if (child != null) {
                print(slate + (char) ('a' + i), child);
            }
        }
    }
}

public class TTrie {

    TrieNode root;

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("sugar");

        System.out.println("Is in trie? " + trie.isExactMatch("apple")); // true
        System.out.println("Is in trie? " + trie.isExactMatch("app")); // false
        System.out.println("Is prefix in trie? " + trie.isPrefix("app")); // true

        trie.insert("app");

        System.out.println("Is in trie? " + trie.isExactMatch("app")); // true

        trie.printValidWords();
    }
}
