package com.example.hand606.studyQnA;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class HomeFragment extends ToolBarFragment {

//    @NonNull
//    public static HomeFragment newInstance() {
//        return new HomeFragment();
//    }

    private TextView tname;
    private TextView email;


    private ImageView phone;
    private ImageView foodi;
    private ImageView bus;
    private ImageView homepage;


    private TextView ddayText;
    private TextView todayText;
    private TextView resultText;
    private Button dateButton;
    private TextView ddayText2;
    private TextView resultText2;
    private Button dateButton2;
    private int chek=1;

    private int tYear;           //오늘 연월일 변수
    private int tMonth;
    private int tDay;

    private int dYear=1;        //디데이 연월일 변수
    private int dMonth=1;
    private int dDay=1;


    private long d;
    private long t;
    private long r;

    private int resultNumber=0;

    static final int DATE_DIALOG_ID=0;

    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//    private User user;


    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setToolbar();
        phone = view.findViewById(R.id.phone);
        foodi = view.findViewById(R.id.food);
        //bus = view.findViewById(R.id.bus);
        //homepage = view.findViewById(R.id.homepage);


//        user.getInstance().setUserName(userf.getDisplayName());
     //   user.getInstance().setEmail(userf.getEmail());
     //   tname.setText(user.getUserName());
    //    email.setText(user.getEmail());
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // 강원대 홈페이지 연결
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://wwwk.kangwon.ac.kr/www/index.do"));
                intent.setPackage("com.android.chrome");
                startActivity(intent);
            }
        });

        foodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // 에브리타임 홈페이지 연결
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://everytime.kr/"));
                intent.setPackage("com.android.chrome");
                startActivity(intent);
            }
        });

//        bus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ajou.ac.kr/kr/life/bus01.jsp"));
//                intent.setPackage("com.android.chrome");
//                startActivity(intent);
//            }
//        });

//        homepage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://eclass2.ajou.ac.kr/"));
//                intent.setPackage("com.android.chrome");
//                startActivity(intent);
//            }
//        });
        tname=view.findViewById(R.id.name);
        email=view.findViewById(R.id.email);
        ddayText=view.findViewById(R.id.dday);
        todayText=view.findViewById(R.id.today);
        resultText=view.findViewById(R.id.result);
        dateButton=view.findViewById(R.id.dateButton);
        tname.setText(user.getDisplayName());
        email.setText(user.getEmail());

        dateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick( View v ) {
                // TODO Auto-generated method stub
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), dDateSetListener, tYear, tMonth, tDay);
                datePickerDialog.show();
                chek=1;

            }
        });
        ddayText2 = view.findViewById(R.id.dday2);
        resultText2 = view.findViewById(R.id.result2);
        dateButton2 = view.findViewById(R.id.dateButton2);
        dateButton2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick( View v ) {
                // TODO Auto-generated method stub
                DatePickerDialog datePickerDialog2 = new DatePickerDialog(getActivity(), dDateSetListener, tYear, tMonth, tDay);
                datePickerDialog2.show();
                chek=2;
            }
        });
        Calendar calendar = Calendar.getInstance();              //현재 날짜 불러옴
        tYear = calendar.get(Calendar.YEAR);
        tMonth = calendar.get(Calendar.MONTH);
        tDay = calendar.get(Calendar.DAY_OF_MONTH);

        Calendar dCalendar = Calendar.getInstance();
        dCalendar.set(dYear, dMonth, dDay);

        t = calendar.getTimeInMillis();                 //오늘 날짜를 밀리타임으로 바꿈
        d = dCalendar.getTimeInMillis();              //디데이날짜를 밀리타임으로 바꿈
        r = (d - t) / (24 * 60 * 60 * 1000);                 //디데이 날짜에서 오늘 날짜를 뺀 값을 '일'단위로 바꿈

        resultNumber = (int) r + 1;
        updateDisplay();

        return view;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때 동작
                getActivity().finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateDisplay() {

        todayText.setText(String.format("%d년 %d월 %d일",tYear, tMonth+1,tDay));
        if(chek==1) {
            ddayText.setText(String.format("%d년 %d월 %d일",dYear, dMonth+1,dDay));

            if(resultNumber>=0){
                resultText.setText(String.format("D-%d", resultNumber));
            }
            else{
                int absR=Math.abs(resultNumber);
                resultText.setText(String.format("D+%d", absR));
            }
        }
        else if(chek==2) {
            ddayText2.setText(String.format("%d년 %d월 %d일", dYear, dMonth + 1, dDay));

            if (resultNumber >= 0) {
                resultText2.setText(String.format("D-%d", resultNumber));
            } else {
                int absR = Math.abs(resultNumber);
                resultText2.setText(String.format("D+%d", absR));
            }
        }
    }//디데이 날짜가 오늘날짜보다 뒤에오면 '-', 앞에오면 '+'를 붙인다

    private DatePickerDialog.OnDateSetListener dDateSetListener=new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet( DatePicker view, int year, int monthOfYear,
                               int dayOfMonth) {
            // TODO Auto-generated method stub
            dYear = year;
            dMonth = monthOfYear;
            dDay = dayOfMonth;
            final Calendar dCalendar = Calendar.getInstance();
            dCalendar.set(dYear, dMonth, dDay);

            d = dCalendar.getTimeInMillis();
            r = (d - t) / (24 * 60 * 60 * 1000);

            resultNumber = (int) r;
            updateDisplay();
        }
    };
    public void setName(String name) {
        tname.setText(name);
    }




}


