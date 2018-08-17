package com.example.student.listview;

/*리스트 뷰의 아이템 한개를 위한 데이터를 저장하는 객체*/
//즉, image 데이터와 name 데이터를 저장하기 위한 객체.
//Activity가 아닌, 일반 java class

public class product {
    private int imageID;    // 이미지 id
    private  String name;    // 상품 이름
    private int count;      // 수량

    public product(int imageID, String name, int count) {
        this.imageID = imageID;
        this.name = name;
        this.count = count;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public int getCount(){
        return count;
    }

}
