package com.switchfully.spaceshark.model.parkingallocation;

import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.model.people.Member;
import com.switchfully.spaceshark.utils.ValidationUtil;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_spot")
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "parkinglot_id")
    private Parkinglot parkinglot;

    public ParkingSpot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        ValidationUtil.throwExceptionIfNullObject(member, "Member");
        this.member = member;
    }

    public Parkinglot getParkinglot() {
        return parkinglot;
    }

    public void setParkinglot(Parkinglot parkinglot) {
        ValidationUtil.throwExceptionIfNullObject(parkinglot, "Parking lot");
        this.parkinglot = parkinglot;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" + "id=" + id + ", member=" + member + ", parkinglot=" + parkinglot + '}';
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        ValidationUtil.throwExceptionIfNullObject(startTime, "Start time");
        this.startTime = startTime;
    }
}
