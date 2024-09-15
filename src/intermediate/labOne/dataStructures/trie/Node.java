package intermediate.labOne.dataStructures.trie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
public class Node {

    private final char character;
    private boolean isEndOfWord;
    public Node(char character) {
        this.character = character;
    }

    @ToString.Exclude
    private Map<Character, Node> children = new HashMap<>();

}
