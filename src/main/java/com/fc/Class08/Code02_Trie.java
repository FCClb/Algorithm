package Class08;

import java.util.HashMap;

/**
 * @Auther: FC.Clb
 * @Date: 2025/2/6 - 02 - 06 - 11:09
 * @Description: Class08
 * @version: 1.0
 */
public class Code02_Trie {
    /*
    前缀树--path用HashMap实现（路的种类较多）
    */
    class Trie {
        class Node {
            public int pass;
            public int end;
            public HashMap<Integer, Node> nexts;

            public Node(){
                pass = 0;
                end = 0;
                nexts = new HashMap<>();
            }
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {//add方法
            if (word == null) {
                return;
            }
            char[] str = word.toCharArray();
            Node node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = (int) str[i];
                if (!node.nexts.containsKey(index)) {
                    node.nexts.put(index, new Node());
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }

        public void erase(String word) {//delete 方法
            if (countWordsEqualTo(word) != 0) {
                char[] chs = word.toCharArray();
                Node node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = (int) chs[i];
                    if (--node.nexts.get(index).pass == 0) {
                        node.nexts.remove(index);
                        return;
                    }
                    node = node.nexts.get(index);
                }
                node.end--;
            }
        }

        public int countWordsEqualTo(String word) {//查询出现几次
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = (int) chs[i];
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.end;
        }

        public int countWordsStartingWith(String pre) {//查询以pre作前缀 出现几次
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = (int) chs[i];
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.pass;
        }
    }
}
