package dataStructures;

class MapSum {

    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode currentNode = root;

        for (char character : key.toCharArray()){
            if (currentNode.get(character) == null){
                currentNode.set(character);
            }

            currentNode = currentNode.get(character);
        }

        currentNode.value = val;
        currentNode.isWord = true;
    }

    public int sum(String prefix) {

        TrieNode currentNode = root;

        for (char character : prefix.toCharArray()){
            if (currentNode.get(character) == null){
                return 0;
            }

            currentNode = currentNode.get(character);
        }

        return getSumFromChildren(currentNode);
    }

    private int getSumFromChildren(TrieNode node){
        int sum = node.value;

        for (TrieNode child : node.characterArray){
            if (child!=null){
                sum = sum + getSumFromChildren(child);
            }
        }

        return sum;
    }

    private static class TrieNode {
        TrieNode[] characterArray;
        int value;

        boolean isWord;

        private static final int SIZE = 26;

        public TrieNode() {
            characterArray = new TrieNode[SIZE];
            value = 0;
            isWord = false;
        }

        public TrieNode get(char x){
            int index = x-'a';
            return characterArray[index];
        }

        public void set(char x){
            int index = x-'a';
            characterArray[index] = new TrieNode();
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("apple"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
