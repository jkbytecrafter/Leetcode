// Java
class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currNode = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (currNode.children[idx] == null) {
                currNode.children[idx] = new TrieNode();
            }

            currNode = currNode.children[idx];
        }

        currNode.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode currNode = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (currNode.children[idx] == null) {
                return false;
            }

            currNode = currNode.children[idx];
        }

        return currNode.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode currNode = root;

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';

            if (currNode.children[idx] == null) {
                return false;
            }

            currNode = currNode.children[idx];
        }

        return true;
    }
}