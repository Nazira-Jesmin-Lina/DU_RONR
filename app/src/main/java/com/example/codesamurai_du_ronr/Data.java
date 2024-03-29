package com.example.codesamurai_du_ronr;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codesamurai_du_ronr.OOP.Agencies;
import com.example.codesamurai_du_ronr.OOP.Components;
import com.example.codesamurai_du_ronr.OOP.Constraints;
import com.example.codesamurai_du_ronr.OOP.Cord;
import com.example.codesamurai_du_ronr.OOP.Projects;
import com.example.codesamurai_du_ronr.OOP.Proposals;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Data {

    ArrayList<Proposals> proposals;

    public ArrayList<Cord> read_project(Context context){
        ArrayList<Cord> cords=new ArrayList<>();
        try {



            InputStream is = context.getAssets().open("projects.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);


            String line;
            String csvSplitBy = ",";




            reader.readLine();


            while ((line = reader.readLine()) != null) {

                String[] dt = line.split(csvSplitBy);

                ArrayList<String> data= new ArrayList<String>(Arrays.asList(dt));;
                ArrayList<String> udata=new ArrayList<>();


                int st1=1,st2=0;

                String Curr="";
                for (int i = 0; i < data.size(); i++) {
                    if(data.get(i).charAt(0)=='\"'){
                        st2=1;
                        st1=0;
                        Curr=Curr+data.get(i);

                        if(data.get(i).charAt(data.get(i).length()-1)=='\"') {


                            StringBuilder sb= new StringBuilder(Curr);
                            sb.deleteCharAt(Curr.length()-1);
                            sb.deleteCharAt(0);
                            udata.add(sb.toString());

                            Curr = "";
                            st2 = 0;
                            st1 = 1;
                        }
                    }
                    else if(data.get(i).charAt(data.get(i).length()-1)=='\"'&&st2==1){





                        Curr=Curr+","+data.get(i);
                        StringBuilder sb= new StringBuilder(Curr);
                        sb.deleteCharAt(Curr.length()-1);
                        sb.deleteCharAt(0);
                        udata.add(sb.toString());

                        Curr="";
                        st2=0;
                        st1=1;
                    }
                    else if(st1==1) {
                        udata.add(data.get(i));
                    }
                    else {
                        Curr=Curr+",";
                        Curr=Curr+data.get(i);
                    }

                }

                for (int i = 0; i < udata.size(); i++) {
                    System.out.println(udata.get(i));
                }

                cords.add(new Cord(udata.get(1), udata.get(2), udata.get(3)));


//                Project new_project = new Project(udata,cords,size);
//                size++;
//                projects.add((new_project));
            }


        }catch (Exception E){
            System.out.println("AAAAAAAAAAAAAAAAAAA "+E.getMessage().toString());
        }
        return cords;
    }

    public ArrayList<Cord> read_proposal(Context context){
        ArrayList<Cord> cords=new ArrayList<>();
        try {



            InputStream is = context.getAssets().open("proposals.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);


            String line;
            String csvSplitBy = ",";




            reader.readLine();


            while ((line = reader.readLine()) != null) {

                String[] dt = line.split(csvSplitBy);

                ArrayList<String> data= new ArrayList<String>(Arrays.asList(dt));;
                ArrayList<String> udata=new ArrayList<>();


                int st1=1,st2=0;

                String Curr="";
                for (int i = 0; i < data.size(); i++) {
                    if(data.get(i).charAt(0)=='\"'){
                        st2=1;
                        st1=0;
                        Curr=Curr+data.get(i);

                        if(data.get(i).charAt(data.get(i).length()-1)=='\"') {


                            StringBuilder sb= new StringBuilder(Curr);
                            sb.deleteCharAt(Curr.length()-1);
                            sb.deleteCharAt(0);
                            udata.add(sb.toString());

                            Curr = "";
                            st2 = 0;
                            st1 = 1;
                        }
                    }
                    else if(data.get(i).charAt(data.get(i).length()-1)=='\"'&&st2==1){

                        Curr=Curr+","+data.get(i);
                        StringBuilder sb= new StringBuilder(Curr);
                        sb.deleteCharAt(Curr.length()-1);
                        sb.deleteCharAt(0);
                        udata.add(sb.toString());

                        Curr="";
                        st2=0;
                        st1=1;
                    }
                    else if(st1==1) {
                        udata.add(data.get(i));
                    }
                    else {
                        Curr=Curr+",";
                        Curr=Curr+data.get(i);
                    }

                }

                for (int i = 0; i < udata.size(); i++) {
                    System.out.println(udata.get(i));
                }

                cords.add(new Cord(udata.get(1), udata.get(2), udata.get(3)));


//                Project new_project = new Project(udata,cords,size);
//                size++;
//                projects.add((new_project));
            }


        }catch (Exception E){
            System.out.println("AAAAAAAAAAAAAAAAAAA "+E.getMessage().toString());
        }
        return cords;
    }

    ArrayList<Projects> get_projects(Context context){
        ArrayList<Projects> ret = new ArrayList<>();
        try {



            InputStream is = context.getAssets().open("projects.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);


            String line;
            String csvSplitBy = ",";




            reader.readLine();


            while ((line = reader.readLine()) != null) {

                String[] dt = line.split(csvSplitBy);

                ArrayList<String> data= new ArrayList<String>(Arrays.asList(dt));;
                ArrayList<String> udata=new ArrayList<>();


                int st1=1,st2=0;

                String Curr="";
                for (int i = 0; i < data.size(); i++) {
                    if(data.get(i).charAt(0)=='\"'){
                        st2=1;
                        st1=0;
                        Curr=Curr+data.get(i);

                        if(data.get(i).charAt(data.get(i).length()-1)=='\"') {


                            StringBuilder sb= new StringBuilder(Curr);
                            sb.deleteCharAt(Curr.length()-1);
                            sb.deleteCharAt(0);
                            udata.add(sb.toString());

                            Curr = "";
                            st2 = 0;
                            st1 = 1;
                        }
                    }
                    else if(data.get(i).charAt(data.get(i).length()-1)=='\"'&&st2==1){





                        Curr=Curr+","+data.get(i);
                        StringBuilder sb= new StringBuilder(Curr);
                        sb.deleteCharAt(Curr.length()-1);
                        sb.deleteCharAt(0);
                        udata.add(sb.toString());

                        Curr="";
                        st2=0;
                        st1=1;
                    }
                    else if(st1==1) {
                        udata.add(data.get(i));
                    }
                    else {
                        Curr=Curr+",";
                        Curr=Curr+data.get(i);
                    }

                }

                for (int i = 0; i < udata.size(); i++) {
                    System.out.println(udata.get(i));
                }

                ret.add(new Projects(udata));




//                Project new_project = new Project(udata,cords,size);
//                size++;
//                projects.add((new_project));
            }


        }catch (Exception E){
            System.out.println("AAAAAAAAAAAAAAAAAAA "+E.getMessage().toString());
        }
        return ret;
    }

    ArrayList<Proposals> get_proposals(Context context){
        ArrayList<Proposals> ret = new ArrayList<>();
        try {



            InputStream is = context.getAssets().open("proposals.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);


            String line;
            String csvSplitBy = ",";




            reader.readLine();


            while ((line = reader.readLine()) != null) {

                String[] dt = line.split(csvSplitBy);

                ArrayList<String> data= new ArrayList<String>(Arrays.asList(dt));;
                ArrayList<String> udata=new ArrayList<>();


                int st1=1,st2=0;

                String Curr="";
                for (int i = 0; i < data.size(); i++) {
                    if(data.get(i).charAt(0)=='\"'){
                        st2=1;
                        st1=0;
                        Curr=Curr+data.get(i);

                        if(data.get(i).charAt(data.get(i).length()-1)=='\"') {


                            StringBuilder sb= new StringBuilder(Curr);
                            sb.deleteCharAt(Curr.length()-1);
                            sb.deleteCharAt(0);
                            udata.add(sb.toString());

                            Curr = "";
                            st2 = 0;
                            st1 = 1;
                        }
                    }
                    else if(data.get(i).charAt(data.get(i).length()-1)=='\"'&&st2==1){





                        Curr=Curr+","+data.get(i);
                        StringBuilder sb= new StringBuilder(Curr);
                        sb.deleteCharAt(Curr.length()-1);
                        sb.deleteCharAt(0);
                        udata.add(sb.toString());

                        Curr="";
                        st2=0;
                        st1=1;
                    }
                    else if(st1==1) {
                        udata.add(data.get(i));
                    }
                    else {
                        Curr=Curr+",";
                        Curr=Curr+data.get(i);
                    }

                }

                for (int i = 0; i < udata.size(); i++) {
                    System.out.println(udata.get(i));
                }

                ret.add(new Proposals(udata));




//                Project new_project = new Project(udata,cords,size);
//                size++;
//                projects.add((new_project));
            }


        }catch (Exception E){
            System.out.println("AAAAAAAAAAAAAAAAAAA "+E.getMessage().toString());
        }
        return ret;
    }
    ArrayList<Agencies> get_agencies(Context context){
        ArrayList<Agencies> ret = new ArrayList<>();
        try {



            InputStream is = context.getAssets().open("agencies.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);


            String line;
            String csvSplitBy = ",";




            reader.readLine();


            while ((line = reader.readLine()) != null) {

                String[] dt = line.split(csvSplitBy);

                ArrayList<String> data= new ArrayList<String>(Arrays.asList(dt));;
                ArrayList<String> udata=new ArrayList<>();


                int st1=1,st2=0;

                String Curr="";
                for (int i = 0; i < data.size(); i++) {
                    if(data.get(i).charAt(0)=='\"'){
                        st2=1;
                        st1=0;
                        Curr=Curr+data.get(i);

                        if(data.get(i).charAt(data.get(i).length()-1)=='\"') {


                            StringBuilder sb= new StringBuilder(Curr);
                            sb.deleteCharAt(Curr.length()-1);
                            sb.deleteCharAt(0);
                            udata.add(sb.toString());

                            Curr = "";
                            st2 = 0;
                            st1 = 1;
                        }
                    }
                    else if(data.get(i).charAt(data.get(i).length()-1)=='\"'&&st2==1){





                        Curr=Curr+","+data.get(i);
                        StringBuilder sb= new StringBuilder(Curr);
                        sb.deleteCharAt(Curr.length()-1);
                        sb.deleteCharAt(0);
                        udata.add(sb.toString());

                        Curr="";
                        st2=0;
                        st1=1;
                    }
                    else if(st1==1) {
                        udata.add(data.get(i));
                    }
                    else {
                        Curr=Curr+",";
                        Curr=Curr+data.get(i);
                    }

                }

                for (int i = 0; i < udata.size(); i++) {
                    System.out.println(udata.get(i));
                }

                ret.add(new Agencies(udata));




//                Project new_project = new Project(udata,cords,size);
//                size++;
//                projects.add((new_project));
            }


        }catch (Exception E){
            System.out.println("AAAAAAAAAAAAAAAAAAA "+E.getMessage().toString());
        }
        return ret;
    }

    ArrayList<Components> get_components(Context context){
        ArrayList<Components> ret = new ArrayList<>();
        try {



            InputStream is = context.getAssets().open("components.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);


            String line;
            String csvSplitBy = ",";




            reader.readLine();


            while ((line = reader.readLine()) != null) {

                String[] dt = line.split(csvSplitBy);

                ArrayList<String> data= new ArrayList<String>(Arrays.asList(dt));;
                ArrayList<String> udata=new ArrayList<>();


                int st1=1,st2=0;

                String Curr="";
                for (int i = 0; i < data.size(); i++) {
                    if(data.get(i).length()==0){
                        String ss="null";
                        udata.add(ss);
                        continue;
                    }
                    if(data.get(i).charAt(0)=='\"'){
                        st2=1;
                        st1=0;
                        Curr=Curr+data.get(i);

                        if(data.get(i).charAt(data.get(i).length()-1)=='\"') {


                            StringBuilder sb= new StringBuilder(Curr);
                            sb.deleteCharAt(Curr.length()-1);
                            sb.deleteCharAt(0);
                            udata.add(sb.toString());

                            Curr = "";
                            st2 = 0;
                            st1 = 1;
                        }
                    }
                    else if(data.get(i).charAt(data.get(i).length()-1)=='\"'&&st2==1){





                        Curr=Curr+","+data.get(i);
                        StringBuilder sb= new StringBuilder(Curr);
                        sb.deleteCharAt(Curr.length()-1);
                        sb.deleteCharAt(0);
                        udata.add(sb.toString());

                        Curr="";
                        st2=0;
                        st1=1;
                    }
                    else if(st1==1) {
                        udata.add(data.get(i));
                    }
                    else {
                        Curr=Curr+",";
                        Curr=Curr+data.get(i);
                    }

                }

                for (int i = 0; i < udata.size(); i++) {
                    System.out.println(udata.get(i));
                }

                ret.add(new Components(udata));




//                Project new_project = new Project(udata,cords,size);
//                size++;
//                projects.add((new_project));
            }


        }catch (Exception E){
            System.out.println("AAAAAAAAAAAAAAAAAAA "+E.getMessage().toString());
        }
        return ret;
    }

    ArrayList<Constraints> get_constraints(Context context){
        ArrayList<Constraints> ret = new ArrayList<>();
        try {



            InputStream is = context.getAssets().open("constraints.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);


            String line;
            String csvSplitBy = ",";




            reader.readLine();


            while ((line = reader.readLine()) != null) {

                String[] dt = line.split(csvSplitBy);

                ArrayList<String> data= new ArrayList<String>(Arrays.asList(dt));;
                ArrayList<String> udata=new ArrayList<>();


                int st1=1,st2=0;

                String Curr="";
                for (int i = 0; i < data.size(); i++) {
                    if(data.get(i).charAt(0)=='\"'){
                        st2=1;
                        st1=0;
                        Curr=Curr+data.get(i);

                        if(data.get(i).charAt(data.get(i).length()-1)=='\"') {


                            StringBuilder sb= new StringBuilder(Curr);
                            sb.deleteCharAt(Curr.length()-1);
                            sb.deleteCharAt(0);
                            udata.add(sb.toString());

                            Curr = "";
                            st2 = 0;
                            st1 = 1;
                        }
                    }
                    else if(data.get(i).charAt(data.get(i).length()-1)=='\"'&&st2==1){





                        Curr=Curr+","+data.get(i);
                        StringBuilder sb= new StringBuilder(Curr);
                        sb.deleteCharAt(Curr.length()-1);
                        sb.deleteCharAt(0);
                        udata.add(sb.toString());

                        Curr="";
                        st2=0;
                        st1=1;
                    }
                    else if(st1==1) {
                        udata.add(data.get(i));
                    }
                    else {
                        Curr=Curr+",";
                        Curr=Curr+data.get(i);
                    }

                }

                for (int i = 0; i < udata.size(); i++) {
                    System.out.println(udata.get(i));
                }

                ret.add(new Constraints(udata));




//                Project new_project = new Project(udata,cords,size);
//                size++;
//                projects.add((new_project));
            }


        }catch (Exception E){
            System.out.println("AAAAAAAAAAAAAAAAAAA "+E.getMessage().toString());
        }
        return ret;
    }

    public void get_prop_from_firebase(){
        proposals=new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("data").child("Proposals").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Proposals props=dataSnapshot.getValue(Proposals.class);

                    proposals.add(props);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    ArrayList<Project_name> search(String name) {
        ArrayList<Project_name> list = new ArrayList<>();
        name=name.toLowerCase();
        for (Proposals prop : proposals) {
            if(prop.name.toLowerCase().contains(name)){
                list.add(new Project_name(prop.name));
            }
        }
        return list;

    }

}
