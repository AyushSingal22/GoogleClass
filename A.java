import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
interface Live{
    
    void addcommet();
    void delcomment();
    void settime();
    void gettime();
    
}
class Commentators{
    private String comment;
    private String time ;
    private String name ;
    public String getComment() {
        return comment;
    }
    public String getName() {
        return name;
    }
    public String getTime() {
        return time;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
class Comment implements Live{
    private DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime time;
    public DateTimeFormatter getForm() {
        return form;
    }
    public LocalDateTime getTime() {
        return time;
    }
    @Override
    public void addcommet() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void delcomment() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void settime() {
        this.time = LocalDateTime.now();
        
    }

    @Override
    public void gettime() {
        System.out.println(form.format(this.time));
        
    }

}
class LiveArea extends Comment{
    private ArrayList<Commentators> live ;
    LiveArea(){
        super();
        live = new ArrayList<>();
    }
    public ArrayList<Commentators> getLive() {
        return live;
    }
    public void setLive(ArrayList<Commentators> live) {
        this.live = live;
    }
    
    public void addcom(Student std) {
        super.settime();
        Scanner sc = new Scanner (System.in);
        System.out.println("Emter Comment : ");
        String s  =  sc.nextLine();
        var c = new Commentators();
        c.setComment(s);
        c.setName(std.getname());
        var fo = getForm();
        super.settime();
        var str =  fo.format(super.getTime());
        c.setTime(str);
        live.add(c);



    }
    public void addcom(Instructor std){
        super.settime();
        Scanner sc = new Scanner (System.in);
        System.out.println("Emter Comment : ");
        String s  =  sc.nextLine();
        var c = new Commentators();
        c.setComment(s);
        c.setName(std.getname());
        var fo = getForm();
        super.settime();
        var str =  fo.format(super.getTime());
        c.setTime(str);
        live.add(c);
    }
    void showComments(){
        System.out.println("------------------------------------------------\n ---------------comments ---------------------");
        for ( var x : live){
            System.out.println(x.getComment() + " \n by " + x.getName() + " \n Time -> " + x.getTime() );
        }
    }
}



interface Form{
    void addcomment();
    void viewcomment();
    void viewlecture();
    void veiwmaterail();
}
class Faculty implements Form{
    private String name;
    String getname(){
        return this.name;
    }
    public Faculty(String name){
        this.name = name;
    }
    public void addcomment(){
        System.out.println("added");
    }
    public void viewlecture(){
        System.out.println("viewit");
    }
    public void viewcomment(){
        System.out.println("veiw comment");
    }
    public void veiwmaterail(){
        System.out.println("materail");
    }

}
class Instructor extends Faculty{
    private ArrayList<Slides> content;
    private ArrayList<Video> vcontent;

    public Instructor(String name){
        super(name);
        content= new ArrayList<>();
        vcontent = new ArrayList<>();
    }
    void addcontent(Slides s){
        this.content.add(s);
    }
    ArrayList<Slides> showcontent(){
        return this.content;
    }
    void addvideo (Video v){
        this.vcontent.add(v);
    }
    ArrayList<Video> getvideos(){
        return vcontent;
    }
    void veiw_lecture_material(){
        System.out.println("--------------------------------\ninstructor name: " +this.getname());
        for ( Slides x : content ){
            System.out.println("Title " + x.getTitle());
            var tempcontent = x.getContent();
            int i =1;
            for (var c : tempcontent){
                System.out.println("Slide "+ i + c);
                i++;
            }
            System.out.print("date of upload --");
            x.gettime();
        }

    }
    
    
}
class Student extends Faculty{
    
    
    public Student(String name){
        super(name);
        
        
    }
    
    
    

}
class Slides {
    private int number;
    private String title;
    private ArrayList<String> content;
    private DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime time; 
    Slides(String title , int num ){
        this.number = num;
        this.title = title;
        content= new ArrayList<>();

    }
    int getNumber(){
        return number;
    }
    String getTitle(){
        return title;
    }
    ArrayList<String> getContent(){
        return content;
    }
    void add_content(String cont){
        this.content.add(cont);
    }
    ArrayList<String> get_content(){
        return this.content;
    }
    void settime(){
        this.time = LocalDateTime.now();
    }
    void gettime (){
        System.out.println(form.format(this.time));
    }
}
class Video {
    private String title;
    private  String filename;
    private DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime time;
    public Video(String x , String y){
        this.filename = y;
        this.title =x;
    }
    String gettitle(){
        return title;
    }
    String getfilename(){
        return filename;
    }
    void settime(){
        this.time = LocalDateTime.now();
    }
    void gettime (){
        System.out.println(form.format(this.time));
    }

}
class Assn{
    private ArrayList<GradingSttudent> students;
    private String name;
    private int  marks;
    public Assn(String name , int marks){
        this.name = name;
        this.marks = marks;
        this.students = new ArrayList<>();
        
    }
    public String getName() {
        return name;
    }
    public int getMarks() {
        return marks;
    }
    public ArrayList<GradingSttudent> getStudents() {
        return students;
    }
    public void addStudent(Student s , int g , String file){
        GradingSttudent x = new GradingSttudent();
        x.setFile(file);
        x.setGrade(g);
        x.setSt(s);
        students.add(x);

    }
    
}
class Quiz{
    private ArrayList<GradingSttudent> students;
    
    private String name;
    private String marks;

    Quiz (String str){
        this.name = str;
        this.students = new ArrayList<>();
        
    }
    public String getMarks() {
        return marks;
    }
    public void setMarks(String marks) {
        this.marks = marks;
    }
    String getname(){
        return this.name;
    }
    public ArrayList<GradingSttudent> getStudents() {
        return students;
    }
    public void addStudent(Student s , int g , String file){
        GradingSttudent x = new GradingSttudent();
        x.setFile(file);
        x.setGrade(g);
        x.setSt(s);
        students.add(x);

    }
}
class GradingSttudent{
    private String status;
    private Instructor inst;
    private Student st ;
    private boolean submit ;
    private int grade;
    private String file;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Instructor getInst() {
        return inst;
    }
    public void setInst(Instructor inst) {
        this.inst = inst;
    }
    public String getFile() {
        return file;
    }
    public void setsubmit(boolean x){
        this.submit = x;
    } 
    public boolean getsubmit(){
        return this.submit;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setSt(Student st) {
        this.st = st;
    }
    public Student getSt() {
        return st;
    }
    Boolean has(Student st){
        return st.equals(this.st);
    }


}
class Assment{
    private ArrayList<Assn> assn;
    private ArrayList<Quiz> quiz;

    public Assment(){
        assn = new ArrayList<>();
        quiz = new ArrayList<>();
    }
    public ArrayList<Assn> getAssn() {
        return assn;
    }
    public ArrayList<Quiz> getQuiz() {
        return quiz;
    }
    void addquiz(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter quiz question : ");
        String inp = sc.nextLine();
        this.quiz.add(new Quiz(inp));
    }
    void addassn(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter problem Statement :");
        String str =  sc.nextLine();
        System.out.println("Enter max marks");
        int marks = sc.nextInt();
        sc.nextLine();
        this.assn.add(new Assn(str, marks));
        


    }
    void viewassns(){
        System.out.println("Assignments");
        int counter =1;
        for ( var x : this.assn){
            System.out.println("ID " + counter +" Assignment :" + x.getName() + " Marks "+ x.getMarks());
            System.out.println("-----------------------------------------------");
            counter++;
        }       
    }
    void veiwquiz(){
        System.out.println("Quizes");
        int counter =1;
        for (var x :this.quiz){
            System.out.println("ID "+counter + "Question :"+x.getname());
            counter ++;
        }
    }
    void pendingAssn(Student stu){
        var list = this.getAssn();
        for (int i =0 ; i< list.size() ; i++){
            var assnum = list.get(i);
            var studentlist = assnum.getStudents();
            boolean found = false;
            
            if (studentlist.isEmpty()){
                System.out.println();
                    System.out.println("pending -------");
                    System.out.println((i+1)+". "+list.get(i).getName() +" Marks -> " + list.get(i).getMarks());
            }
            else{
            for ( int j = 0 ; j < studentlist.size() ; j++){
                var student = studentlist.get(j);
                if ( student.getSt().equals(stu) && list.get(i).getStudents().get(j).getsubmit() ){
                    System.out.println();
                    System.out.println((i+1) +". Submitted already");
                    found = true;
                }
                else{
                    System.out.println();
                    
                    System.out.println("pending -------");
                    System.out.println();
                    System.out.println((i+1)+". "+list.get(i).getName());
                }
                
                
            }
            }
        }  

    }
    
    void submitAssn(Student stu){
        Scanner sc = new Scanner(System.in);
        pendingAssn(stu);
        System.out.print("Enter Id of Assignment : \n 99 to exit ---");
        int index = sc.nextInt();
        
        sc.nextLine();
        if ( index == 99 ) return;
        var tempassn = this.assn.get(index-1);
        var tempgradingstudent = tempassn.getStudents();
        GradingSttudent student;
        
        System.out.println(tempassn.getName());
       
        String file = getfile();
        tempassn.addStudent(stu, -1, file);
        int tempstuindex = -1;
        for ( int i = 0 ; i < tempgradingstudent.size() ; i++){
            var x = tempgradingstudent.get(i);
            if ( x.getSt() .equals(stu)){
                student = x;
                tempstuindex = i;
            }

        }
        tempassn.getStudents().get(tempstuindex).setStatus("ungraded");
        tempassn.getStudents().get(tempstuindex).setsubmit(true);


        
        
    }
    
    void pendingQuiz(Student stu){
        var list = this.getQuiz();
        for (int i =0 ; i< list.size() ; i++){
            var assnum = list.get(i);
            var studentlist = assnum.getStudents();
            boolean found = false;
            if (studentlist.isEmpty()){
                System.out.println();
                    System.out.println("pending -------");
                    System.out.println((i+1)+". Question "+list.get(i).getname());
            }
            else{
            for ( int j = 0 ; j < studentlist.size() ; j++){
                var student = studentlist.get(j);
                if ( student.getSt().equals(stu) && list.get(i).getStudents().get(j).getsubmit() ){
                    System.out.println();
                    System.out.println((i+1) +". Question -->Submitted already");
                    found = true;
                }
                else{
                    System.out.println();
                    
                    System.out.println("pending -------");
                    System.out.println();
                    System.out.println((i+1)+". "+list.get(i).getname());
                }
                
                
            }
            }
        }  

    }
    void submitQuiz(Student stu){
        Scanner sc = new Scanner(System.in);
        pendingQuiz(stu);
        System.out.print("Enter Id of Quiz : \n 99 to exit  ->");
        int index = sc.nextInt();
        
        sc.nextLine();
        if ( index == 99 ) return;
        var tempquiz = this.quiz.get(index-1);
        var tempgradingstudent = tempquiz.getStudents();
        GradingSttudent student;
        
        System.out.print("Question--"+tempquiz.getname()+" ans -> ");
       
        String file = sc.next();
        tempquiz.addStudent(stu, -1, file);
        int tempstuindex = -1;
        for ( int i = 0 ; i < tempgradingstudent.size() ; i++){
            var x = tempgradingstudent.get(i);
            if ( x.getSt() .equals(stu)){
                student = x;
                tempstuindex = i;
            }

        }
        tempquiz.getStudents().get(tempstuindex).setStatus("ungraded");
        tempquiz.getStudents().get(tempstuindex).setsubmit(true);
    }

    private String getfile(){
        Scanner sc = new Scanner (System.in);
        boolean flag = true;
        String name="";
        while(flag ){
            System.out.println("Enter the file NAme: ");
            name = sc.nextLine();
            int len  = name.length();
            if (len<=4) {
                System.out.println("wrong file format");
                continue;
            }
            String str ="";
            str = str + name.charAt(len-4) + name.charAt(len-3) + name.charAt(len-2) + name.charAt(len-1);
            if (str.equals(".zip")) flag =false;
            else {
                flag = true;
                System.out.println("wrong file format");
            }
            
        }
        
        return name;
        
        
    }
    
    void gradeAssn(Instructor ist){
        Scanner sc = new Scanner(System.in);
        System.out.println("Chose on of the following assignments");
        var assnlist = this.getAssn();
        viewassns();
        System.out.println("Select by entering the id : -> ");
        int indexofassn = sc.nextInt() -1;
        var studentlist =  assnlist.get(indexofassn).getStudents();
        sc.nextLine();
        System.out.println( "\n chose the index of the student you want to grade \n ----------------------------------");
        for ( int i = 0 ; i <  studentlist.size() ; i++) {
            System.out.println((i+1)+ ". " + studentlist.get(i).getSt().getname()  );

        } 

        System.out.println(" index -> ");
        int studentindex = sc.nextInt()-1;
        sc.nextLine();
        var stud = studentlist.get(studentindex);
        System.out.println("------------------------\n Submission -->" + stud.getFile());
        System.out.println("-----------------------------------------");
        System.out.println("Max marks - "+ assnlist.get(indexofassn).getMarks());
        int marks ;
        System.out.println("Marks scored -- ");
        marks = sc.nextInt();
        sc.nextLine();
        stud.setGrade(marks);
        stud.setInst(ist);
        stud.setStatus("Graded");
        
    }
    void gradeQuiz(Instructor ist){
        Scanner sc = new Scanner(System.in);
        System.out.println("Chose on of the following assignments");
        var list = this.getQuiz();
        veiwquiz();
        System.out.println("Select by entering the id : -> ");
        int indexofassn = sc.nextInt() -1;
        var studentlist =  list.get(indexofassn).getStudents();
        sc.nextLine();
        System.out.println( "\n chose the index of the student you want to grade \n 99 to go back ----------------------------------");
        for ( int i = 0 ; i <  studentlist.size() ; i++) {
            System.out.println((i+1)+ ". " + studentlist.get(i).getSt().getname() + "Status -> "+studentlist.get(i).getStatus()   );

        } 

        System.out.println(" index -> ");
        int studentindex = sc.nextInt()-1;
        sc.nextLine();
        if (studentindex == 99 ) return;
        var stud = studentlist.get(studentindex);
        System.out.println("------------------------\n Submission -->" + stud.getFile());
        System.out.println("-----------------------------------------");
        
        int marks ;
        System.out.println("Marks scored -- ");
        marks = sc.nextInt();
        sc.nextLine();
        stud.setGrade(marks);
        stud.setInst(ist);
        stud.setStatus("Graded");
    }
    void showGrade(Student std){
        System.out.println("your submissions");
        for ( var x : this.assn){
            var ass = x.getStudents();
            for ( int i = 0 ; i < ass.size() ; i++){
                var temp = ass.get(i);
                if (temp.getSt().equals(std)){
                    if (temp.getStatus().equals("Graded")){
                    System.out.println( x.getName() + " your file -> " + temp.getFile() + "\n marks obtained : " + temp.getGrade() +"\ngraded by "+ temp.getInst().getname() );
                    System.out.println("--------------------------------------------");
                    }
                    else {
                        System.out.println(x.getName()+ " " + temp.getStatus());
                    }

                }

            }


        }
    }
    void remove_A(){
        var sc = new Scanner (System.in);
        System.out.println("Chose the assgn : ");
        for (int i = 0 ; i < assn.size() ; i++){
            System.out.println((i+1) +". "+ assn.get(i).getName());

        }
        System.out.println("enter -1 to slct null");
        int in  = sc.nextInt();
        sc.nextLine();
        if (in == -1) return;
        assn.remove(in);
        
    }
    void remove_Q(){
        var sc = new Scanner (System.in);
        System.out.println("Chose the Quiz : ");
        for (int i = 0 ; i < quiz.size() ; i++){
            System.out.println((i+1) +". "+ quiz.get(i).getname());

        }
        System.out.println("enter -1 to slct null");
        int in  = sc.nextInt();
        sc.nextLine();
        if (in == -1) return;
        quiz.remove(in);
        
    }
}

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        var student_list = new ArrayList<Student>();
        var instructor_list = new ArrayList<Instructor>();
        var live = new LiveArea();
        var assess =  new Assment();


        student_list.add(new Student("S0"));
        student_list.add(new Student("S1"));
        student_list.add(new Student("S2"));
        instructor_list.add(new Instructor("I0"));
        instructor_list.add(new Instructor("I1"));





        
        int  choice , choice2;
        while (true){
            menu();
            System.out.print("Enter your choice: ");
            choice =sc.nextInt();
            if (choice==3) break;
            else if(choice==1) { // instructor
                int choice3;
                while(true){
                    for (int i =0 ; i < instructor_list.size() ; i++){
                        System.out.println(i+". " + instructor_list.get(i).getname());
                        
                    }
                    
                    System.out.println("-1. to go back");
                    System.out.print("-> ");
                    choice3 = sc.nextInt();
                    if (choice3==-1) break;
                    var tempInstructor  = instructor_list.get(choice3);
                    System.out.println( "--Welcome--"+tempInstructor.getname()+"--");
                    int choice4;
                    while (true){
                        lmenu();
                        choice4 = sc.nextInt();
                        if (choice4==9) break;
                        if (choice4==1){   // adding class material
                            int choice_material;
                            System.out.println("1. Add Lecture Slide\n2. Add Lecture Video\n");
                            choice_material=sc.nextInt();
                            sc.nextLine();
                            
                            if (choice_material == 1){
                                
                                String title;
                                int number;
                                System.out.print("Toopic :");
                                title = sc.nextLine();
                                
                                System.out.print("\nNo. of Slides: ");
                                number=sc.nextInt();
                                sc.nextLine();

                                System.out.println("Enter the content of SLides :");
                                
                                var slide = new Slides(title, number);
                                for (int i =0 ; i< number; i++){
                                    String cont;
                                    System.out.println("Content of slide " + (i+1) );
                                    
                                    cont = sc.nextLine();
                                    slide.add_content(cont);
                                    }
                                slide.settime();
                                tempInstructor.addcontent(slide);
                                
                                System.out.println("---------------------------------------");
                                
                            }
                            else if (choice_material==2){ // video material
                                System.out.println("Enter Topic of the video: ");
                                String top = sc.nextLine();
                                
                                String fname = getfname();
                                var vx = new Video(top, fname);
                                vx.settime();
                                tempInstructor.addvideo(vx);
                                System.out.print("file added at :");
                                vx.gettime();
                                
                            }
                        }

                        if(choice4 == 2) { // adding assesments
                            System.out.println("1. add Assn \n2. Add Quiz");
                            int slct  = sc.nextInt();
                            sc.nextLine();
                            if(slct ==1){
                                assess.addassn();
                            }
                            else if (slct ==2){
                                assess.addquiz();
                                
                            }
                            else {
                                System.out.println("wrong selection try again....");
                            }
                            
                        }

                        if (choice4 == 3){ //  veiw lecture material
                            for (var x : instructor_list){
                                x.veiw_lecture_material();
                            }
                        }
                        if (choice4 ==4){ // veiw ass materail
                            sc.nextLine();
                            assess.viewassns();
                            assess.veiwquiz();
                        
                        }
                        if (choice4==5){ // grade assessments....
                            System.out.println("1. for grading Assin \n2. for grading Quizes");
                            int sct =  sc.nextInt();
                            if (sct ==1 ){ // assn
                                assess.gradeAssn(tempInstructor);
                            }
                            else if (sct ==2){ // quizes
                                assess.gradeQuiz(tempInstructor);
                            }
                            else{
                                System.out.println("wrong input try again");
                            }
                        
                        }
                        if (choice4 == 6){ // close assessment...
                            System.out.println("chose the assesment \n1. Assignment \n2. Quiz ");
                            int slct = sc.nextInt();
                            sc.nextLine();
                            if (slct == 1 ){
                                assess.remove_A();
                            }
                            else if (slct == 2){
                                assess.remove_Q();
                            }   
                            else System.out.println("something wrong try again");
                        }
                        if (choice4 == 7 ){
                            live.showComments();
                        }
                        if (choice4 ==8){
                            live.addcom(tempInstructor);
                        }
                    }
                }


                
                
            }
            else if (choice ==2){ // student
                int choice3;
                while(true){

                    for (int i =0 ; i < student_list.size() ; i++){
                        System.out.println(i+". " + student_list.get(i).getname());
                        
                    }
                    
                    System.out.println("-1. to go back");
                    System.out.print("-> ");
                    choice3 = sc.nextInt();
                    
                    if (choice3==-1) break;
                    var tempStudent  = student_list.get(choice3);

                    int choice4;
                    while(true || choice4 == 7){
                        smenu();
                        choice4 = sc.nextInt();
                        if (choice4 == 7) break;
                        if (choice4==1){ // material
                            for (var x : instructor_list){
                                x.veiw_lecture_material();
                            }
                        }
                        if (choice4 == 2){ // viewing assessments
                            System.out.println("Assignments ----");
                            assess.viewassns();
                            System.out.println("Quizzess---------");
                            assess.veiwquiz();
                        }
                        if (choice4 ==3){ // Submit assessment
                            int slct;
                            System.out.println(" 1 ->Assigments  ");
                            System.out.println(" 2 ->Quizes  ");
                            slct=sc.nextInt();
                            sc.nextLine();
                            if (slct == 1){
                                System.out.println("following are pending assignments----");
                                
                                assess.submitAssn(tempStudent);
                            }
                            else if (slct ==2){
                                System.out.println("following are pending Quizes -----------");

                                assess.submitQuiz(tempStudent);
                                
                            }
                            else {
                                System.out.println("wrong selection try again,,,");
                            }
                        }
                        if (choice4 == 4){ // check grades
                            assess.showGrade(tempStudent);
                        }
                        if (choice4 == 6 ) // adding comments
                        {
                            live.addcom(tempStudent);
                        }
                        if (choice4 == 5) // show comments 
                        {
                            live.showComments();
                        }
                    }
                    

                    
                }
                
            }
            else System.out.println("Invalid input try again...");

        }



        sc.close();
    }
    public static void menu(){
        System.out.println("-------backpack------------\n1.Instructor \n2.Student\n3.exit\n----------------------------");
    }
    public static void lmenu(){
        System.out.println("--------------------------\n1. Add class material\n2. Add assessments\n3. View lecture materials\n4. View assessments\n5. Grade assessments\n6. Close assessment\n7. View comments\n8. Add comments\n9. Logout\n---------------------------------------");
    }
    public static void smenu(){
        System.out.println("--------------------------\n1. View lecture materials\n2. View assessments\n3. Submit assessment\n4. View grades\n5. View comments\n6. Add comments\n7. Logout\n-----------------------------------------");
    }
    public static void slidemenu(){
        System.out.println("");
    }
    public static String getfname(){
        Scanner sc = new Scanner (System.in);
        boolean flag = true;
        String name="";
        while(flag ){
            System.out.println("Enter the file NAme: ");
            name = sc.nextLine();
            int len  = name.length();
            if (len<=4) {
                System.out.println("wrong file format");
                continue;
            }
            String str ="";
            str = str + name.charAt(len-4) + name.charAt(len-3) + name.charAt(len-2) + name.charAt(len-1);
            if (str.equals(".mp4")) flag =false;
            else {
                flag = true;
                System.out.println("wrong file format");
            }
            
        }
        return name;
        
        
    }
}

  

