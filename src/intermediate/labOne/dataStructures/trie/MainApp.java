package intermediate.labOne.dataStructures.trie;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        // Create an instance of the Trie
        Trie trie = new Trie();

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("bat");
        trie.insert("batch");
        trie.insert("banana");

        // Test autocomplete functionality
        String prefix = "app";
        List<String> suggestions = trie.wordsWithPrefix(prefix);

        // Display the autocomplete suggestions
        System.out.println("Words that start with '" + prefix + "':");
        for (String word : suggestions) {
            System.out.println(word);
        }

        // Try a different prefix
        prefix = "ba";
        suggestions = trie.wordsWithPrefix(prefix);

        // Display the autocomplete suggestions for the new prefix
        System.out.println("\nWords that start with '" + prefix + "':");
        for (String word : suggestions) {
            System.out.println(word);
        }

        // Check if a word exists in the Trie
        String wordToCheck = "application";
        if (trie.contains(wordToCheck)) {
            System.out.println("\nThe word '" + wordToCheck + "' exists in the Trie.");
        } else {
            System.out.println("\nThe word '" + wordToCheck + "' does not exist in the Trie.");
        }

        // Check if a prefix exists in the Trie
        String prefixToCheck = "bat";
        if (trie.containsPrefix(prefixToCheck)) {
            System.out.println("\nThe prefix '" + prefixToCheck + "' exists in the Trie.");
        } else {
            System.out.println("\nThe prefix '" + prefixToCheck + "' does not exist in the Trie.");
        }
    }

}
