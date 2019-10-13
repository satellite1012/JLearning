package linked_list;

class Node
{
	int info;
	Node next;
    Node() {}
	Node(int x, Node p)
	{
		info=x;
		next=p;
	}
	Node(int x)
	{
		this(x,null);
	}
}

class intSinglyLinkedList
{
	Node head, tail;

	intSinglyLinkedList()			// Constructor khởi tạo empty list
	{
		head = tail = null;
	}
	boolean isEmpty()				// Kiểm tra empty list
	{
		return(head == null);
	}
	void clear()					// Xóa tất cả phần tử trong list
	{
		head = tail = null;
	}
	void addToHead(int x)			// 1. Thêm phần tử vào đầu list
	{
		Node p = new Node(x, head);
		if (isEmpty())
		{
			head = tail = p;
			return;
		}
		head = p;
	}
	void addToTail(int x)			// 2. Thêm một node vào cuối list
	{
		Node p = new Node(x);
		if (isEmpty())
		{
			head = tail = p;
			return;
		}
		tail.next = p;
		tail = p;
	}
	void addAfter(Node p, int x)	// 3. Thêm phần tử vào sau một node
	{
		if(contains(p))
		{
			p.next = new Node(x, p.next);
		}
	}
	void traverse()					// 4. In ra giá trị của tất cả node trong danh sách
	{
		if (!isEmpty())
		{
			System.out.println("The list now:");
			Node p = head;
			while(p != null)
			{
				visit(p);
				p = p.next;
			}
			System.out.println("\n");
		}
		else System.out.print("List is empty!");
	}
	void traverse_recursion()
	{
		if (isEmpty())
		{
			System.out.print("Empty list");
			return;
		}
		System.out.println("Traverse using recursion\nThe list now: ");
			traverse_recursion(head);
		System.out.println("\n");
	}
	private void traverse_recursion(Node p)		// 4.1. In ra danh sach su dung de quy
	{
		if(p != null)
		{
			visit(p);
			traverse_recursion(p.next);
		}
	}
	int deleteFromHead()			// 5. Xóa node đầu tiên, return giá trị của nó
	{
		if(!isEmpty())
		{
			int tmp = head.info;
			head = head.next;
			return tmp;
		}
		return -1;
	}
	int deleteFromTail()			// 6. Xóa node cuối cùng, return giá trị của nó
									// Chưa xét trường hợp list có 1 phần tử
	{
		int tmp = tail.info;
		if (!isEmpty())
		{
			Node p = head;
			while((p.next).next != null)
			{
				p = p.next;
			}
			tail = p;
			tail.next = null;
		}
		return tmp;
	}
	int deleteAter(Node p)			// 7. Xóa 1 node sau p, return giá trị của nó
	{
		if(!isEmpty() && contains(p) && !tail.equals(p))
		{
			int tmp = (p.next).info;
			if(p.next.equals(tail))
			{
				p.next = null;
				tail = p;
			}
			else
			{
				p.next = (p.next).next;
			}
			return tmp;
		}
		return -1;
	}
	void dele(int x)				// 8. Xóa node đầu tiên bằng x
	{
		if (!isEmpty())
		{
			Node p = search(x);
			if(p.equals(tail))
			{
				deleteFromTail();
			}
			else if(p.equals(head))
			{
				deleteFromHead();
			}
			else
			{
				Node tmp = head;
				while(!tmp.next.equals(p))
				{
					tmp = tmp.next;
				}
				tmp.next = p.next;
			}
		}
	}
	Node search(int x)				// 9. Tìm kiếm 1 node có giá trị là x, return phần từ cuối nếu hong có
	{
		Node p = head;
		while(p != null && p.info != x)
		{
			p = p.next;
		}
		return p;
	}
	int count()						// 10. đếm và trả về số phần tử trong list
	{
		int tmp = 0;
		Node p = head;
		while(p != null)
		{
			tmp++;
			p = p.next;
		}
		return tmp;
	}
	void dele_th(int i)				// 11. Xóa phần tử thứ i
	{
		int tmp = 0;
		Node p = head;
		if(count()<i+1)
		{
			System.out.println("Not in list");
			return;
		}
		if(i == 0)
		{
			deleteFromHead();
			return;
		}
		while(p != null)
		{
			if (tmp == i-1)
			{
				deleteAter(p);
				return;
			}
			tmp++;
			p = p.next;
		}
	}
	void sort()						// 12. Sắp xếp danh sách, quicksort
	{
		Node pi,pj; int t;
		pi=head;
		while(pi!=null)
		{
			pj=pi.next;
	   		while(pj!=null)
			{
				if(pj.info<pi.info)
		  		{
					t=pi.info;pi.info=pj.info;pj.info=t;
		  		} 
		 	pj=pj.next;
			}
		pi=pi.next;
		}
	}
	void dele(Node p)				// 13. Xóa node p nếu có trong dãy
	{
		if(!isEmpty() && contains(p))
		{
			if(p.equals(head))
			{
				head = p.next;
				return;
			}
			Node tmp = head;
			while(tmp.next != p)
			{
				tmp = tmp.next;
			}
			tmp.next = p.next;
			if(p.equals(tail)) tail = tmp;
		}
	}
	int [] toArray()				// 14. Trả về mảng chứ tất cả phần tử trong list
	{
		int arr[] = new int[count()];
		int i = 0;
		Node p = head;
		while(p != null)
		{
			arr[i] = p.info;
			i++;
			p = p.next;
		}
		return arr;
	}
	static intSinglyLinkedList Merge(intSinglyLinkedList lst1, intSinglyLinkedList lst2)
									// 15. Gom 2 danh sách đã sắp xếp
	{
		// Câu này em làm nhiều bug quá, cô cho em làm kiểu củ chuối này cũng được nha cô!
		intSinglyLinkedList lst = lst1;
		lst.Attatch(lst2);
		lst.sort();
		return lst;
	}
	void addBefore(Node p, int x)	// 16. Thêm một node vào trước 1 node
	{
		if(contains(p) && !isEmpty())
		{
			Node tmp = head;
			if(p.equals(head))
			{
				addToHead(x);
				return;
			}
			while (!tmp.next.equals(p))
			{
				tmp = tmp.next;
			}
			tmp.next = new Node(x, p);
		}
	}
	void Attatch(intSinglyLinkedList lst)
									// 17. Ghép list lst vào sau list hiện tại
	{
		if(!lst.isEmpty())
		{
			Node p = lst.head;
			while(p != null)
			{
				addToTail(p.info);
				p = p.next;
			}
		}
	}
	int max()						// 18. Lấy giá trị lớn nhất
	{
		sort();
		return tail.info;
	}
	int min()						// 19. Lấy giá trị nhỏ nhất
	{
		sort();
		return head.info;
	}
	int sum()						// 20. Lấy tổng
	{
		Node p = head;
		int ret = 0;
		while(p!=null)
		{
			ret= p.info;
			p = p.next;
		}
		return ret;

	}
	int avg()						// 21. Lấy trung bình cộng
	{
		Node p = head;
		int sum = 0, count = 0;
		while(p!=null)
		{
			sum += p.info;
			count++;
			p = p.next;
		}
		return sum/count;

	}
	boolean sorted()				// 22. Kiểm tra đã sắp xếp
	{
		if(isEmpty()) return true;
		Node p = head;
		while(p.next != null)
		{
			if (p.info>p.next.info) return false;
			p = p.next;
		}
		return true;
	}
	void insert(int x)				// 23. Chèn x vào danh sách để tạo danh đã sắp xếp
	{
		Node p = new Node(x, head);
		if (isEmpty())
		{
			head = tail = p;
			return;
		}
		else if (x<=head.info)
		{
			head = p;
		}
		else if(x>=tail.info)
		{
			addToTail(x);
		}
		else
		{
			p = head;
			while(p != null && p.next.info<=x)
			{
				p = p.next;
			}
			addAfter(p, x);
		}
	}
	void reverse()					// 24. Đảo ngược dãy chỉ lặp 1 lần
	{
		if(!isEmpty())
		{
			Node p = head;
			while(p != tail)
			{
				addToHead(p.next.info);
				deleteAter(p);
				// traverse();	// for debug
			}
		}
	}
	boolean compare(intSinglyLinkedList lst)
									// 25. So sánh content của 2 danh sách
	{
		this.sort(); lst.sort();
		Node p1 = this.head;
		Node p2 =  lst.head;
		while(p1 != null)
		{
			if(p1.info != p2.info) return false;
			p1 = p1.next;
			p2 = p2.next;
			if((p1==null && p2!=null) || (p1!=null && p2==null))return false;
		}
		return true;
	}
	void visit(Node p)				// In ra giá trị tại một node
	{
		System.out.print(p.info + " ");
	}
	boolean contains(Node p)		// Kiểm tra trong list có chứa node p không
	{
		Node tmp = head;
		while(tmp != null)
		{
			if (tmp.equals(p)) return true;
			tmp = tmp.next;
		}
		return false;
	}
}

public class IntegerLinkedList
{
	public static void main(String[] args)
	{
		Example_traverse_recursion();
		// Example1_2_3_4();
		// Example5();
		// Example6();
		// Example7();
		// Example8();
		// Example9();
		// Example10();
		// Example11();
		// Example12();
		// Example13();
		// Example14();
		// Example15();
		// Example16();
		// Example17();
		// Example18();
		// Example19();
		// Example20();
		// Example21();
		// Example22();
		// Example23();
		// Example24();
		// Example25();
	}

	static void Example_traverse_recursion()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);

		intls.addToHead(7);

		intls.addAfter(intls.head, 9);

		intls.traverse();
		intls.traverse_recursion();
	}
	static void Example1_2_3_4()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);

		intls.addToHead(7);

		intls.addAfter(intls.head, 9);

		intls.traverse();
	}
	static void Example5()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);

		intls.deleteFromHead();

		intls.traverse();
	}
	static void Example6()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);

		intls.deleteFromTail();

		intls.traverse();
	}
	static void Example7()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);

		intls.deleteAter(intls.head);

		intls.traverse();
	}
	static void Example8()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(2);	// ****
		intls.addToTail(3);

		intls.dele(2);

		intls.traverse();
	}
	static void Example9()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);

		intls.traverse();

		Node node = intls.search(2);
		System.out.println("Node at: " + node.toString() + " has value: " + node.info);
	}
	static void Example10()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);

		System.out.println("List has " + intls.count() + " elements.");
	}
	static void Example11()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);
		intls.addToTail(4);

		intls.dele_th(2);

		intls.traverse();
	}
	static void Example12()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(5);
		intls.addToTail(3);
		intls.addToTail(2);
		intls.addToTail(8);

		intls.sort();

		intls.traverse();
	}
	static void Example13()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);
		intls.addToTail(4);

		intls.dele(intls.head.next);
		intls.dele(new Node(5, null));

		intls.traverse();
	}
	static void Example14()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();

		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);
		intls.addToTail(4);

		intls.traverse();
		
		System.out.println("Array is:");
		int arr[] = intls.toArray();
		for (int i : arr)
		{
			System.out.print(i + " ");
		}
	}
	static void Example15()
	{
		intSinglyLinkedList intls1 = new intSinglyLinkedList();
		intls1.addToTail(1);
		intls1.addToTail(2);
		intls1.addToTail(3);
		
		intSinglyLinkedList intls2 = new intSinglyLinkedList();
		intls2.addToTail(1);
		intls2.addToTail(2);
		intls2.addToTail(3);

		intSinglyLinkedList intls = intSinglyLinkedList.Merge(intls1, intls2);
		intls.traverse();
	}
	static void Example16()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();
		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);

		Node testNode = intls.search(2);
		intls.addBefore(testNode, 5);

		intls.traverse();
	}
	static void Example17()
	{
		intSinglyLinkedList intls1 = new intSinglyLinkedList();
		intls1.addToTail(1);
		intls1.addToTail(2);
		intls1.addToTail(3);

		intSinglyLinkedList intls2 = new intSinglyLinkedList();
		intls2.addToTail(1);
		intls2.addToTail(2);
		intls2.addToTail(3);

		intls1.Attatch(intls2);

		intls1.traverse();
	}
	static void Example18()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();
		intls.addToTail(1);
		intls.addToTail(6);
		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(8);
		intls.addToTail(4);
		intls.addToTail(5);
		intls.addToTail(7);

		System.out.print("Max of list is: " + intls.max());
	}
	static void Example19()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();
		intls.addToTail(1);
		intls.addToTail(6);
		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(8);
		intls.addToTail(4);
		intls.addToTail(5);
		intls.addToTail(7);

		System.out.print("Min of list is: " + intls.min());
	}
	static void Example20()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();
		intls.addToTail(1);
		intls.addToTail(6);
		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(8);
		intls.addToTail(4);
		intls.addToTail(5);
		intls.addToTail(7);

		System.out.print("Sum of list is: " + intls.sum());
	}
	static void Example21()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();
		intls.addToTail(1);
		intls.addToTail(6);
		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(8);
		intls.addToTail(4);
		intls.addToTail(5);
		intls.addToTail(7);

		System.out.print("Average of list is: " + intls.avg());
	}
	static void Example22()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();
		intls.addToTail(1);
		intls.addToTail(6);
		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(8);
		intls.addToTail(4);
		intls.addToTail(5);
		intls.addToTail(7);

		// intls.sort();
		System.out.print("The list is " + (intls.sorted() ? "sorted!" : "not sorted!"));
	}
	static void Example23()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();
		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);

		intls.insert(2);
		intls.insert(3);
		intls.insert(4);

		intls.traverse();
	}
	static void Example24()
	{
		intSinglyLinkedList intls = new intSinglyLinkedList();
		intls.addToTail(1);
		intls.addToTail(2);
		intls.addToTail(3);
		intls.addToTail(4);
		intls.addToTail(5);

		intls.reverse();

		intls.traverse();
	}
	static void Example25()
	{
		intSinglyLinkedList intls1 = new intSinglyLinkedList();
		intls1.addToTail(1);
		intls1.addToTail(2);
		intls1.addToTail(3);
		
		intSinglyLinkedList intls2 = new intSinglyLinkedList();
		intls2.addToTail(1);
		intls2.addToTail(3);
		intls2.addToTail(3);

		System.out.println(intls1.compare(intls2) ? "They have the same elements" : "They have different elements");
	}
}