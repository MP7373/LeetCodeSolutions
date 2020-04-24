import java.util.*;

class LRUCache {

  int size = 0;
  int capacity;
  DoublyLinkedIntegerNode lru = null;
  DoublyLinkedIntegerNode mru = null;
  Map<Integer, DoublyLinkedIntegerNode> map = new HashMap<>();
  
  public LRUCache(int capacity) {
      this.capacity = capacity;
  }
  
  public int get(int key) {
      if (map.containsKey(key)) {
          var node = map.get(key);
          
          if (node == lru && size > 1) {
              lru = node.tail;
          }

          makeNodeMru(node);

          return node.val;
      }

      return -1;
  }
  
  public void put(int key, int value) {
      if (!map.containsKey(key)) {
          if (size == 0) {
              var node = new DoublyLinkedIntegerNode(key, value, null, null);
              lru = node;
              mru = node;
              
              map.put(key, node);
          } else {
              var node = new DoublyLinkedIntegerNode(key, value, mru, null);

              mru.tail = node;
              mru = node;

              if (capacity == size) {
                  size--;

                  map.remove(lru.key);

                  lru = lru.tail;
                  lru.head = null;
              }
              
              map.put(key, node);
          }

          size++;
      } else {
          var node = map.get(key);
          
          if (node == lru && size > 1) {
              lru = lru.tail;
          }

          node.val = value;
          makeNodeMru(node);
      }
  }
  
  private void makeNodeMru(DoublyLinkedIntegerNode node) {
      if (node != mru) {
          if (node.head != null) {
              node.head.tail = node.tail;
          }

          if (node.tail != null) {
              node.tail.head = node.head;
          }

          node.head = mru;
          node.tail = null;
          mru.tail = node;

          mru = node;
      }
  }
}

class DoublyLinkedIntegerNode {

  int key;
  int val;
  DoublyLinkedIntegerNode head;
  DoublyLinkedIntegerNode tail;
  
  DoublyLinkedIntegerNode(int key, int val, DoublyLinkedIntegerNode head, DoublyLinkedIntegerNode tail) {
      this.key = key;
      this.val = val;
      this.head = head;
      this.tail = tail;
  }
}

/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache obj = new LRUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/
