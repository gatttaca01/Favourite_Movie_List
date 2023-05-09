public class LinkedList {
    private InfoNode head; // Başlangıç düğümünün işaretçisini tutar

    // Constructor metodu, başlangıç düğümünü null olarak belirler
    public LinkedList() {
        this.head = null;
    }

    // Yeni bir bilgi düğümü ekler
    public void addInfo(String content) {
        InfoNode newNode = new InfoNode(content);
        if (head == null) {
            head = newNode;
        } else {
            InfoNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Belirli bir bilgi düğümünü arar ve bulursa true, bulamazsa false döndürür
    public boolean searchInfo(String content) {
        InfoNode current = head;
        while (current != null) {
            if (current.getContent().equals(content)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Belirli bir bilgi düğümünü siler
    public boolean deleteInfo(String content) {
        InfoNode current = head;
        InfoNode previous = head;

        while (current != null) {
            if (current.getContent().equals(content)) {
                if (current == head) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }

        return false;
    }

    // Bağlantılı listedeki tüm bilgi düğümlerini bir listede toplar ve bu listeyi döndürür
    public ArrayList<String> listInfo() {
        ArrayList<String> infoList = new ArrayList<>();
        InfoNode current = head;
        while (current != null) {
            infoList.add(current.getContent());
            current = current.getNext();
        }
        return infoList;
    }
}
