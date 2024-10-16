
package it2c.alcala.midterm;

import java.util.Scanner;


public class IT2CALCALAMIDTERM {
public void addAppointment(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print (" Appointment date: ");
        String appdate = sc.next();
        
        System.out.print (" Appointment time: ");
      String apptime = sc.next();
        System.out.print( " Status(Scheduled/Completed): ");
        String status = sc.next();

        String sql = "INSERT INTO appointment (appointment_date,appointment_time,a_status) VALUES ( ?, ?,?)";


        conf.addAppointment(sql, appdate, apptime, status);


    }
    public static void main(String[] args) {
      
       Scanner sc=new Scanner(System.in);
       String response;
       do{
           System.out.println ("1. ADD");
           System.out.println ("2. VIEW");
           System.out.println ("3. UPDATE");
           System.out.println ("4. DELETE");
           System.out.println ("5. EXIT");
           
           System.out.println("Enter Action:");
            int action =sc.nextInt();
            IT2CALCALAMIDTERM appoint= new IT2CALCALAMIDTERM ();
            switch(action){
                case 1:
                     
                    appoint.addAppointment();
           break;
                case 2:
                     
                     appoint.viewAppointment();
                     
                case 3:
                    
                        appoint.viewAppointment();
                    appoint.updateAppointment();
                case 4:
                    
                       appoint.viewAppointment();
                        appoint.deleteAppointment();
                   appoint.viewAppointment();
            }
            System.out.println("Continue?(yes/no):");
            response=sc.next();
       }while(response.equals("yes"));
            System.out.println("Thank you for using");
              
             
            

    
    }
    
    private void viewAppointment() {
   
        String appointmentQuery = "SELECT * FROM appointment";
        String [] appointmentHeaders = {"ID","Appointment date"," Appointment time","Status"};
        String[] appointmentColumns = {"appointment_id", "appointment_date", "appointment_time","a_status"};
       config conf = new config();
        conf.viewAppointment(appointmentQuery, appointmentHeaders, appointmentColumns);
    }
    private void updateAppointment(){

     Scanner sc= new Scanner(System.in);   
        System.out.println  ("Enter Appointment ID:");
        int id = sc.nextInt();
        System.out.println ("Enter new Appointment date:");
        String nappdate= sc.next();
        System.out.println ("Enter new Appointment time:");
      int  napptime= sc.nextInt();
       
        System.out.println ("Enter new Status:");
        String nstat= sc.next();


        String qry = "UPDATE appointment SET appointment_date = ?,appointment_time = ?,  a_status = ? WHERE appointment_id = ?";

        config conf = new config();
        conf.updateAppointment(qry, nappdate,napptime,nstat,id);

       }
    private void deleteAppointment(){

        Scanner sc= new Scanner(System.in);   
           System.out.println("Enter appointmentID to delete:");
           int id = sc.nextInt();

           String sqlDelete = "DELETE FROM appointment  WHERE appointment_id=?";
           config conf = new config();
           conf.deleteAppointment(sqlDelete, id);
       }

}
