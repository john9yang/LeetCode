package tree;

class DNSCache{
    //IP地址最多有11个不同的字符
    private final int CHAR_COUNT = 11;

    //IP地址最大的长度
    private TrieNode root = new TrieNode();
    public class TrieNode{
        boolean isLeaf;
        String url;
        TrieNode[] child; //CHAR_COUNT

        public TrieNode(){
            this.isLeaf = false;
            this.child = new TrieNode[CHAR_COUNT];
        }
    }

    public int getIndexFromChar(char c){
        return (c == '.')?10:(c-'0');
    }

    public char getCharFromIndex(int i){
        return (i==10)?'.':(char)('0'+i);
    }

    /**
     * 把一个IP地址和相应的URL添加到Trie树中,最后一个结点是URL
     */
    public void insert(String ip,String url){
        //IP地址的长度
        int len = ip.length();
        TrieNode pCrawl = root;

        int level;
        for (level = 0; level < len; level++) {
            //根据当前遍历到的ip中的字符,找出子结点的索引
            int index = getIndexFromChar(ip.charAt(level));
            //如果子结点不存在,则创建一个
            if( pCrawl.child[index] == null )
                pCrawl.child[index] = new TrieNode();

            //移动到子结点
            pCrawl = pCrawl.child[index];
        }

        //在叶子结点中存储IP对应的URL
        pCrawl.isLeaf = true;
        pCrawl.url = url;
    }

    /**
     * 通过IP地址找到对应的URL
     */
    public String searchDNSCache(String ip){
        TrieNode pCrawl = root;
        int len = ip.length();

        int level;
        for (level = 0; level < len; level++) {
            int index = getIndexFromChar(ip.charAt(level));
            if ( pCrawl.child[index] == null )
                return null;
            pCrawl = pCrawl.child[index];
        }

        if( pCrawl != null && pCrawl.isLeaf ){
            return pCrawl.url;
        }

        return null;
    }
}

public class Test5 {
    public static void main(String[] args) {
        String[] ipAdds = {"10.57.11.127","121.57.61.129","66.125.100.103"};
        String[] url = {"www.samsung.com","www.samsung.net","www.google.in"};
        int n = ipAdds.length;
        DNSCache cache = new DNSCache();

        //把IP地址和对应的URL插入到Trie树中
        for (int i = 0; i < n; i++) {
            cache.insert(ipAdds[i],url[i]);
        }

        String ip = "121.57.61.129";
        String res_url = cache.searchDNSCache(ip);
        if ( res_url != null ){
            System.out.println("找到ip对应的URL:"+res_url);
        }
        else
            System.out.println("没有找到ip对应的URL");
    }
}
