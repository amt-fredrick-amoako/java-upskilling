package intermediate.labOne.dataStructures.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie implements Tree {

    private final Node root;

    public Trie() {
        root = new Node(' ');
    }

    @Override
    public Tree insert(String word) {
        Node currentNode = root;
        Map<Character, Node> children = root.getChildren();
        for (char c : word.toCharArray()) {
            if (children.containsKey(c)) {
                currentNode = children.get(c);
            } else {
                Node newNode = new Node(c);
                children.put(c, newNode);
                currentNode = newNode;
            }
            children = currentNode.getChildren();
        }
        currentNode.setEndOfWord(true);
        return this;
    }

    @Override
    public boolean contains(String word) {
        Node lastNode = search(word);
        return lastNode != null && lastNode.isEndOfWord();
    }

    @Override
    public boolean containsPrefix(String prefix) {
        return search(prefix) != null;
    }

    private Node search(String str) {
        Node currentNode = root;
        Map<Character, Node> children = root.getChildren();
        for (char c : str.toCharArray()) {
            if (!children.containsKey(c)) {
                return null;
            }
            currentNode = children.get(c);
            children = currentNode.getChildren();
        }
        return currentNode;
    }

    @Override
    public List<String> wordsWithPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        Node prefixNode = search(prefix);
        if (prefixNode != null) {
            addWords(prefixNode, prefix, words);
        }
        return words;
    }

    private void addWords(Node node, String word, List<String> wordList) {
        if (node.isEndOfWord()) {
            wordList.add(word);
        }
        for (Node child : node.getChildren().values()) {
            addWords(child, word + child.getCharacter(), wordList);
        }
    }

    @Override
    public void delete(String word) {
        List<Node> nodes = new ArrayList<>();
        Node currentNode = root;
        Map<Character, Node> children = root.getChildren();
        for (char c : word.toCharArray()) {
            if (!children.containsKey(c)) {
                return; // Word not found
            }
            currentNode = children.get(c);
            nodes.add(currentNode);
            children = currentNode.getChildren();
        }
        if (!currentNode.isEndOfWord()) {
            return; // Word doesn't exist
        }
        currentNode.setEndOfWord(false); // Unmark the end of the word
        for (int i = nodes.size() - 1; i > 0; i--) {
            Node node = nodes.get(i);
            if (node.getChildren().isEmpty() && !node.isEndOfWord()) {
                nodes.get(i - 1).getChildren().remove(node.getCharacter());
            } else {
                break; // Stop if current node is still part of another word
            }
        }
    }
}

