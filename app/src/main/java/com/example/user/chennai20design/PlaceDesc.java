package com.example.user.chennai20design;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceDesc extends AppCompatActivity {

    String[] PlaceName={"Anna Memorial","Birla Planaturium","Chennai Turtle Walk"
            ,"Chokhi Dhani","Egmore Museum","Gandhi Statue","Light House","Labour Statue","Bharathiar Statue","Kannagi Statue","Netaji Subhas Chandra Bose Statue","Thiruvalluvar Statue","G U Pope Statue","Bharathidasan Statue","Avvaiyar Statue","Veeramamunivar Statue","MGR Memorial"};

    String[] PlaceImage={"anna","birla","walk",
            "chokhi","egmore","gandhi","lighthouse","statuemarinabeach","e","yy","ooo","dd","gu","k","a","v","memorial"};

    String[] desc={"Anna memorial, locally known as Anna Samadhi, is a memorial structure built on the Marina beach in Chennai, India. It was built in memory of former Chief Minister of Tamil Nadu, C. N. Annadurai, who was cremated here in 1969","B. M. Birla Planetarium is a large planetarium in Chennai providing a virtual tour of the night sky and holding cosmic shows on a specially perforated hemispherical aluminium inner dome\n\n" + "Entery fee : Rs.40 per person",
            "Join independent conservation and wildlife enthusiast groups such as the Students’ Sea Turtle Conservation Network for midnight walks from Neelangarai to Besant Nagar beach to aid the endangered Olive Ridley sea turtle by relocating eggs for safe release to the sea"
            ,"Chokhi Dhani is a concept capturing the vibrant spirit of Rajasthan and ensuring a perfect Rajasthani experience.  Inbound and native tourists have a desire to experience the unique Rajasthani culture. The real Rajasthan, the villages, the paintings, Bani Thani art, the wall decorations, Dipak wall, the fresh air, the evening performances, the enthusiasm, the 'manuhar' (a delicate request to eat till your heart’s desire), the traditions, the costumes and at last but not least the Feelings."
            ,"The Government Museum or Madras Museum is a museum of human history and culture located in the neighbourhood of Egmore in Chennai, India. Started in 1851, it is the second oldest museum in India after the Indian Museum in Kolkata\n\n" +
            "Entrance Fee\n\n\tIndian Nationals\n\t\tAdults : Rs. 15/-\n\t\t" +
            "Child : Rs. 10/- below 12 years\n\t\t" +
            "Rs. 5/- for bonafide students and teachers in groups with prior permission\n\t" +
            "Non-Indian Nationals\n\t\tAdults : Rs. 250/-\n\t\t" +
            "Child : Rs. 125/-\n\t\t" +
            "Rs. 75/- for bonafide students and teachers in groups with prior permission\n\n"+
            "Camera Fee : Rs. 200/- per camera.\n" +
            "Video Camera : Rs. 500/- per video camera","It’s a majestic statue of the Mahatma by the sea on the Marina Walk. The place is clean and well kept. The beach is right next to the statue and when I went (on a Tuesday evening), it was not crowded at all. If you prefer walking, this place can serve as the starting point for a walk by the beach."
            ,"Concrete lighthouse opened in 1977, standing at 46m & with a viewing gallery open to the public.","This is a labor statue, dedicated to the various laborers who work hard to build every nation. Since I went there on May 1 (International Workers/ Laborers day), the statue was even garlanded!","This is the statue of a famous Tamil poet in Tamil Nadu called Bharathiar (There is also a wannabe Bharathiar in blue shirt below :) ). His poems aroused the people of Tamil Nadu against the British rule and he also fought against gender inequality, caste-ism and other evils thronging the society back then, primarily through his poems. He was also called Maha Kavi."
            ,"Kannagi is the main character in the Tamil epic called Silapadhikaram, written by Illango Adigal before 1400 years. In the story, she comes to know that her husband had been accused of stealing an anklet of the queen, and put to death by the Madurai King. But she goes to the palace & proves that her husband had not committed the crime. The King, shameful of his hasty decision, dies right there. The legend is that whole of Madurai city was in flames shortly after.","Netaji Subhas Chandra Bose was a revolutionary freedom fighter who fought against the British empire in India from outside India (South East Asia). Unlike the leaders of the congress back then, he believed that an armed military campaign against the British was the way to complete Independence and he was helped in this cause by the Germans (initially) and the Japanese (mostly). His reported death after a few campaigns in the North Eastern front of India in 1945 due to a plane crash has never been established till now.","Thiruvalluvar, is a very famous Tamil poet who is famous for his work – Thirukkural which contains 1330 couplets and deals with the topics on Virtue, Wealth & Love. Though it has been written 2000 years ago, the poems are considered very relevant, even today. The above statue is an imagined portrait of the great thinker and poet."
            ,"G U Pope, has translated several Tamil poems and epics (including Tirukkural) in to English over a period spanning 53 years. He has also translated other large volumes like Naladiyar, Thiruvasagam, etc.","Bharathidasan is a Tamil poet, writer and playwright whose mentor was Bharathiar. He mostly wrote on socio-political issues that helped the Dravidian movement to rise in Tamil Nadu. He was posthumously awarded the Sahitya Academy award in 1970.","Avvaiyar, is the collective name for a group of female poets who lived in 1st/ 3rd/ 13th Centuries in Tamil Nadu. Avvaiyar has written many poems/ songs in Tamil. Aathichoodi is a very popular work among them, which is simple to understand & contains wise words.","Veera-ma-munivar (Italian name: Constanzo Beschi) was a missionary who arrived to South India from Europe in the 18th Century. He learned the Tamil language and became proficient enough in it to write a dictionary in Tamil (among other works) and introduced grammar for the popular usage of Tamil. His translations of famous Tamil works in to Latin gave a positive introduction to Tamil Literature in Europe.","MGR memorial is a memorial structure built on the Marina beach in Chennai, India. It was built in memory of former Chief Minister of Tamil Nadu, M. G. Ramachandran"};

    String[] loc={"Triplicane\nChennai\nTamil Nadu 600005","No. 4,Gandhi Mandapam Road\nKotturpuram, Chennai\nTamil Nadu 600025\n" +
            "Phone: 044 2441 0025"," 8/25, 2nd Street, DP Nagar\nKotturpuram, Chennai\nTamil Nadu 600090\n" +
            "Phone: +91-9789864166","NH-4, Near Queensland Theme Park, Kevlur Road\nTandalam, Sriperambudur, Chennai\nTamil Nadu 602105\n" +
            "Phone:080560 06677","Pantheon Road, Beside Ashoka Hotel\nEgmore, Chennai\nTamil Nadu 600008\n" +
            "Phone: 044 2819 3778","Marina Beach Road\nChennai","Mylapore\nChennai\nTamil Nadu 600004","Marina Beach Road\nChennai","Beach Road,Near Triplicane\n" +
            "Chennai\nTamil Nadu 600005","Bharathi Salai, Triplicane\nChennai\nTamil Nadu 600005","Kamarajar Salai Rd\nTriplicane, Chennai\nTamil Nadu 600005","Marina Beach Road\nChennai","Salai Rd\nTriplicane, Chennai\nTamil Nadu 600005","Bharathi Salai\nTriplicane, Chennai\nTamil Nadu 600005","Avvai Shanmugam Salai\nMylapore, Chennai\nTamil Nadu 600005","Near Air Radio Office, Santhome\nChennai\n" +
            "Tamil Nadu 600004","Chepauk, Triplicane\nChennai\nTamil Nadu 600005"};

    String[] time={
            "9:00 AM - 8:00 PM (Other Sections)\n" +
            "8:00 AM - 9:00 PM \n" +
            "Days : Daily"
            ,"Opening Time : 12:00 PM\nClosing Time : 06:30 PM\n" +
            "Days : Daily",
            "Open : Daily",
            "Opening Time : 4 PM\nClosing Time : 10 PM\nOpen : Daily",
            "Opening Time : 9:30 AM\nClosing Time : 5 PM\nOpen : Daily\n\nHolidays : Fridays and National Holidays",
            "Open : Daily","Morning : 10 AM - 1 PM\nEvening : 3 PM - 6 PM\nHolidays : Monday",
            "Open : Daily","Open : Daily","Open : Daily","Open : Daily","Open : Daily","Open : Daily","Open : Daily","Open : Daily","Open : Daily","Opening Time : 9 AM\n" +
            "Closing Time : 5 PM\n" +
            "Open : Daily\n\nHolidays : Tuesdays"};

    String[] web={"http://www.annacentenarylibrary.com/2011/02/sections.html","http://www.myvisitinghours.org/birla-planetarium-80","https://www.tripadvisor.in/Attraction_Review-g304556-d2706098-Reviews-Chennai_Turtle_Walk-Chennai_Madras_Tamil_Nadu.html","https://www.ixigo.com/chokhi-dhani-village-jaipur-india-opening-visiting-timing-hours-closed-days-ne-1300611","http://www.chennaimuseum.org/draft/geninfo/geninfo.htm"
            ,"http://www.destinationinfinity.org/2011/05/15/statues-of-famous-personalities-along-the-marina-beach-in-chennai/","http://livechennai.com/detailnews.asp?newsid=8196","http://www.destinationinfinity.org/2011/05/15/statues-of-famous-personalities-along-the-marina-beach-in-chennai/","https://www.vidteq.com/vs/wowPlace.php?city=chennai&id=a+TVBiXAuLx4+m+UJF0bTbS0JhDPBDkv2CPGzQ5Nahg=&name=Subramaniya%20Bharathiar%20Statue"
            ,"http://tamilnation.co/diaspora/tamilnadu/060606kannagi.htm","http://www.destinationinfinity.org/2011/05/15/statues-of-famous-personalities-along-the-marina-beach-in-chennai/","http://www.destinationinfinity.org/2011/05/15/statues-of-famous-personalities-along-the-marina-beach-in-chennai/","https://www.ixigo.com/gu-pope-statue-chennai-india-ne-1355222","https://en.wikipedia.org/wiki/Marina_Beach","https://www.ixigo.com/avvaiyar-statue-chennai-india-ne-1355220","http://124.153.106.196/vs/wowPlace.php?city=chennai&id=zwfgUll6r/X25Fh+IaqPR+N4WrVN1Wh/M0gjXRLJblc=&name=Veeramamunivar%20Statue","http://www.mgrhome.org/memorial.html"};

    TextView txtPlaceName,txtDesc,txtLoc,txtTime,txtImg;
    int id;
    String placeName;
    ImageButton imgWeb,imgLoc,btnBack;
    Uri uri1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_desc);


        txtImg=(TextView)findViewById(R.id.imgsrc);
        txtPlaceName=(TextView)findViewById(R.id.placenamedesc);
        txtDesc=(TextView)findViewById(R.id.txtDesc);
        txtLoc=(TextView)findViewById(R.id.placeaddrdesc);
        txtTime=(TextView)findViewById(R.id.txtTime);
        imgWeb=(ImageButton)findViewById(R.id.btnWeb);
        imgLoc=(ImageButton)findViewById(R.id.btnLoc);
        btnBack=(ImageButton)findViewById(R.id.btnBack);

        Intent intent=getIntent();

        id=(int)intent.getLongExtra("id", 0);
        Log.e("InfoPlace", String.valueOf(id));
        txtPlaceName.setText(PlaceName[id]);

        String name=PlaceImage[id];
        String uri = "@drawable/"+name;

        int imageResource = getResources().getIdentifier(uri, null, getPackageName());



        txtImg.setBackgroundResource(imageResource);
        txtDesc.setText(desc[id]);
        txtLoc.setText(loc[id]);
        txtTime.setText(time[id]);

        uri1 = Uri.parse("http://"+web[id]);

        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(intent);
            }
        });

        imgLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Coming soon",Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlaceDesc.this,MonumentsNavDrawer.class);
                startActivity(intent);
                finish();
            }
        });




    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(PlaceDesc.this,MonumentsNavDrawer.class);
        startActivity(intent);
        finish();
    }
}
