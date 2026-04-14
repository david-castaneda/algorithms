# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

class TrieNode:
    
    def __init__(self, value = None):
        self.value = value
        self.children = [0] * 26
        self.is_word = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
        
    # O(log(n))
    def insert(self, word):
        cur = self.root
        for c in word:
            idx = ord(c) - ord('a') # 0 - 26
            if cur.children[idx] != 0:
                cur = cur.children[idx]
            else:
                node = TrieNode(c)
                cur.children[idx] = node
                cur = node
        
        cur.is_word = True
        
    # O(log(n)) 
    def search(self, word):
        cur = self.root
        for c in word:
            idx = ord(c) - ord('a') # 0 - 26
            if cur.children[idx] != 0:
                cur = cur.children[idx]
            else:
                return False
        return cur.is_word
        
    # O(log(n)) 
    def startsWith(self, prefix):
        cur = self.root
        for c in prefix:
            idx = ord(c) - ord('a') # 0 - 26
            if cur.children[idx] != 0:
                cur = cur.children[idx]
            else:
                return False
        return True