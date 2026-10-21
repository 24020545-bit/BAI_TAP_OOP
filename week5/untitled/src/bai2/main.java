package bai2;

import java.util.LinkedList;
import java.util.Stack;

class Customer{
    int id;
    String name;
    public Customer(int id, String name){
        this.id=id;
        this.name=name;
    }
}
class Message{
    int id;
    String content;
    public Message(int id, String content){
        this.content=content;
        this.id=id;
    }
    public String getContent(){
        return content;
    }
    @Override
    public String toString() {
        return content;
    }
}
class Ticket{
    int id;
    String content;
    long timestamp;
    public Ticket(int id, String content, long timestamp){
        this.content=content;
        this.id=id;
        this.timestamp=timestamp;
    }
}

class CustomerQueue{
    LinkedList<Customer> customerQueue = new LinkedList<>();

    public void addCustomer(Customer customer){
        customerQueue.add(customer);
    }
    public Customer processCustomer(){
        if(customerQueue.isEmpty()){
            System.out.println("Khong con khach doi");
            return null;
        }
        return customerQueue.poll();
    }
}
class MessageHistory{
    Stack<Message> stack = new Stack<>();
    int nextId = 1;
    public void addMessageHistory(String content){
        stack.add(new Message(nextId++,content));
    }
    public void Undo(){
        stack.pop();
    }
    public void ViewLast() {
        if (stack.isEmpty()) {
            System.out.println("Chua co cau nao");
        } else {
            System.out.println("Cau vua go: "+stack.peek().getContent());
        }
    }
    public void showHistory() {
        System.out.println(stack);
    }
}

public class main {
    public static void main(String[] args) {
        CustomerQueue customerQueue = new CustomerQueue();
        MessageHistory messageHistory = new MessageHistory();

        // 1. Khach A va B den
        Customer A = new Customer(1, "A");
        Customer B = new Customer(2, "B");

        customerQueue.addCustomer(A);
        customerQueue.addCustomer(B);

        // 2. Xu ly khach A
        Customer current = customerQueue.processCustomer();

        if (current != null) {
            Ticket ticket = new Ticket(
                    current.id,
                    "Ho tro khach hang " + current.name,
                    System.currentTimeMillis()
            );

            System.out.println("Ticket: " + ticket.content);

            // 3. Nhan vien go 3 dong tin nhan
            messageHistory.addMessageHistory("Xin chao quy khach!");
            messageHistory.addMessageHistory("Chung toi se kiem tra don hang.");
            messageHistory.addMessageHistory("Don hang se den ngay mai.");
            // 4. Xem tin nhan vua go
            messageHistory.ViewLast();
            // 5. Undo tin nhan cuoi cung
            messageHistory.Undo();
            // 6. Xem lai lich su tin nhan
            messageHistory.showHistory();
        }
        // 7. Xu ly khach B
        customerQueue.processCustomer();
        // 8. Thu xu ly khi hang doi rong
        customerQueue.processCustomer();
    }
}
