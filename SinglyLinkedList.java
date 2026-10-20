/**
 * SinglyLinkedList
 */
public class SinglyLinkedList implements LinkedList{

    public Node head,tail;
    private int size=0;

    public SinglyLinkedList(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public int size(){
        return size;
    }
    public void addFirst(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node baru = new Node(inputData);
        Node C=head;
        for(int i=0;i<index;i++){
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=1;i<size;i++){
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.pointer;
            }
            temp.pointer = temp.pointer.pointer;
            size--;
        }
    }

    public void print(){
        Node currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index di luar batas linked list");
        }

        Node pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.pointer;
        }

        return pointer.data;
    }
    @Override
    public int indexOf(Object targetData) {
        Node pointer = head;
        int index = 0;

        while (pointer != null) {
            if (pointer.data.equals(targetData)) {
                return index;
            }

            pointer = pointer.pointer;
            index++;
        }

        return -1;
    }
    @Override
    public void printReverse() {
        printReverseRecursive(head);
    }

    private void printReverseRecursive(Node pointer) {
        if (pointer == null) {
            return;
        }

        printReverseRecursive(pointer.pointer);
        System.out.println(pointer.data);
    }

    @Override
    public boolean remove(Object targetData) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(targetData)) {
            head = head.pointer;
            size--;

            if (head == null){
                tail = null;
            }

            return true;
        }

        Node pointer = head;

        while (pointer.pointer != null) {
            if (pointer.pointer.data.equals(targetData)) {
                Node nodeDihapus = pointer.pointer;
                pointer.pointer = nodeDihapus.pointer;

                if (nodeDihapus == tail) {
                    tail = pointer;
                }
                
                size--;
                return true;
            }

            pointer = pointer.pointer;
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node pointer = head;
        int index = 0;

        while (pointer != null) {
            array[index] = pointer.data;
            pointer = pointer.pointer;
            index++;
        }

        return array;
    }
}