package com.example.appSpring.repository;

import com.example.appSpring.model.Trainee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TraineeRepository {
    private List<Trainee> trainees;

    public TraineeRepository(){
        this.trainees = new ArrayList<>();
    }

    public Trainee addTrainee(Trainee trainee){
        trainees.add(trainee);
        return trainee;
    }

    public Trainee getById(int id){
        return trainees.stream().filter(t->t.getId()==id).findFirst().orElse(null);
    }

    public Trainee deleteId(int id){
        Trainee temp = new Trainee();
        for(Trainee t :trainees){
            if(t.getId() == id){
                temp = t;
                trainees.remove(t);
                break;
            }
        }

        return temp;
    }

    public List<Trainee> getAll(){
        return trainees;
    }

}
