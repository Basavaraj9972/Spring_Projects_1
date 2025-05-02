package com.tap;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Sort implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        int dateComparison = b1.getDate().compareTo(b2.getDate());
        if (dateComparison != 0) {
            return dateComparison;
        }

        int idComparison = Integer.compare(b1.getId(), b2.getId());
        if (idComparison != 0) {
            return idComparison;
        }

        int nameComparison = b1.getName().compareTo(b2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }

        int authorComparison = b1.getAuthor().compareTo(b2.getAuthor());
        if (authorComparison != 0) {
            return authorComparison;
        }

        return Float.compare(b1.getPrice(), b2.getPrice());
    }
}


class Book {
    private int id;
    private String name;
    private String author;
    private float price;
    private LocalDate date;

    public Book() {}

    public Book(int id, String name, String author, float price, LocalDate date) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + author + " " + price + " " + date;
    }
}

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline left-over
        Sort sort = new Sort();
        TreeSet<Book> treeSet = new TreeSet<Book>(sort);
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] ar = line.split(",");
            int id = Integer.parseInt(ar[0]);
            String name = ar[1];
            String author = ar[2];
            float price = Float.parseFloat(ar[3]);
            LocalDate date = LocalDate.parse(ar[4]);
            Book book = new Book(id, name, author, price, date);
            treeSet.add(book);
        }
        for (Book b : treeSet) {
            System.out.println(b);
        }
        sc.close();
    }
}


//
//import java.util.Comparator;
//import java.util.Scanner;
//import java.util.TreeSet;
//class Sort implements Comparator<Book>{
//	public int compare(Book b1, Book b2) {
//		if(b1.getDate().compareTo(b2.getDate())!=0) {
//			return b1.getDate().compareTo(b2.getDate());
//		}
//		else if(b1.getId()-b2.getId()!=0) {
//			return b1.getId()-b2.getId();
//		}
//		else if(b1.getName().compareTo(b2.getName())!=0){
//			return b1.getName().compareTo(b2.getName());
//		}
//		else if(b1.getAuthor().compareTo(b2.getAuthor())!=0) {
//			return b1.getAuthor().compareTo(b2.getAuthor());
//		}
//		else {
//			return (int)(b1.getPrice()-b2.getPrice());
//		}
//	}
//}
//
//class Book {
//	private int id;
//	private String name;
//	private String author;
//	private float price;
//	private String date;
//	
//	public Book() {
//
//	}
//
//	public Book(int id, String name, String author, float price, String date) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.author = author;
//		this.price = price;
//		this.date = date;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public float getPrice() {
//		return price;
//	}
//
//	public void setPrice(float price) {
//		this.price = price;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//	
//	@Override
//	public String toString() {
//		return id+" "+name+" "+author+" "+price+" "+date;
//	}
//	
//}
//public class Demo {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		Sort sort = new Sort();
//		TreeSet<Book> treeSet = new TreeSet<Book>(sort);
//		for(int i=0;i<n;i++) {
//			String[] ar =sc.next().split(",");
//			int id = Integer.parseInt(ar[0]);
//			String name = ar[1];
//			String author = ar[2];
//			float price = Float.parseFloat(ar[3]);
//			String date = ar[4];
//			Book book = new Book(id,name,author,price,date);
//			treeSet.add(book);
//		}
//		for( Book b : treeSet) {
//			System.out.print(b);
//		}
//	}
//
//}
//1,java,Gems,3344,2023-10-14
//2,c++,Raj,2022-02-13
//3,java,ranga,2024-12-23

