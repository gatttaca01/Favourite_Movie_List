public class InfoNode {
    private String content; // Düğüm içeriği
    private InfoNode next; // Sonraki düğümün işaretçisini tutar

    // Constructor metodu, düğüm içeriğini parametre olarak alır
    public InfoNode(String content) {
        this.content = content;
        this.next = null;
    }

    // Getter ve setter metotları
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public InfoNode getNext() {
        return next;
    }

    public void setNext(InfoNode next) {
        this.next = next;
    }
}
