import java.util.List;

public class Room {
    private String roomType;
    private int noOfBeds;
    private double rent;
    private int roomNo;
    private int status;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Room(String roomType, int noOfBeds, double rent, int roomNo) {
        this.roomType = roomType;
        this.noOfBeds = noOfBeds;
        this.rent = rent;
        this.roomNo = roomNo;
        this.status = 0;
    }

    public Boolean isVacant(Room r)
    {
        if(r.status==1)
            return false;
        else
            return true;
    }

    public void displayDetail(){
        System.out.println("Room Type: "+this.roomType);
        System.out.println("Number of Beds: " + this.noOfBeds);
        System.out.println("Rent: "+this.rent);
        System.out.println("Room Number: "+this.roomNo);
        if(status == 1){
            System.out.println("Occupied");
        }
        else{
            System.out.println("Vacant");
        }
    }

    public void vacateRoom(int rno){
        for(int i=0;i<6;i++)
        {
            if(this.roomNo == rno){
                this.status =0;
            }
        }
    }

    public void displayAvailable(List<Room> r){
        for(Room room: r){
            if(room.status ==0){
                room.displayDetail();
            }
        }
    }
}
