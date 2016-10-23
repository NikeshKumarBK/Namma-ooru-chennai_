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

public class SpiDesc extends AppCompatActivity {

    String[] PlaceName={"Ashtalakshmi Temple","Kalikambal Temple","Arupadai Veedu Murugan Temple","Kapaleeshwar Temple","Ananthaa Padmanabha Swaamy Temple","Little Mount Shrine","Marundeeswarar Temple","Ramakrishna Temple","San Thome Church","Shirdi Sai Baba Temple","Sri Parthasarathy Temple","Thirumalai Thirupathi Devasthanam","Vadapalani Murugan Temple",
            "Ayyappan Temple","Ranganatha Temple","Dhenupureeswarar Temple","Padi Sivan Temple","Devi Karumariamman","Periyapalayam Amman","Sholingur Lakshmi Narasimha Swamy "};

    String[] PlaceImage={"ashtalakshmi","entrance","g","photo0jpg","ananthaa","inside","marundeeswarar","ramakrishna","caption","shirdi","sriparthasarathy","thirumalai","vadapalani","download","ranganatha","entrance1","blissful","dh","periyapalayamamman","gg"};

    String[] desc={"The temple is located on the shores of the Bay of Bengal, Besant Nagar Beach, Besant Nagar, Chennai, Tamil Nadu, India. this is the only temple dedicated to Sri Mahalaksahmi, the Consort of Sriman Narayanan (Sri Mahavishnu), on the east coast in Tamil Nadu.","The Kalikambal Temple is a Hindu temple dedicated to Goddess Kalikambal and Lord Kamateswarar, located in George Town, Chennai, India. The temple is located on Thambu Chetty Street, a prominent financial street running parallel to Rajaji Sala","Lord Subramania or Muruga has 6 temples exclusively dedicated to him in various places - Palani, Thiruthani, Thiruchendur, Thiruparankundram, Swamimalai, and Pazhamudircholai and in different forms. This temple has the lord as he is in all the above places in the same place. The beauty of the temple, the circular pattern in which the sanctum sanctorum of each place is done. This temple is a must visit in Besant Nagar in the sea shore."
            ,"One of the sacred shrines in Tamil Nadu is Arulmigu Kapaleeswarar Temple in Mylapore, in Chennai City.It is a Siva Temple, and the name of the Lord is ARULMIGU KAPALEESWARAR. The name of the Goddess is ARULMIGU KARPAGAMBAL.It is a loverly temple with a Stately Spire or ‘Gopuram’ as it is called. There is a big tank on its West. The temple and the tank are surrounded by Broad streets on the four sides. The view of the temple and the tank is picturesque. ","he origin of the Temple of Sree Padmanabhaswamy is lost in antiquity. It is not possible to determine with any exactitude, from any reliable historical documents or other sources as to when and by whom the original idol of Sree Padmanabhaswamy was consecrated. The Temple has references in Epics and Puranas. Srimad Bhagavatha says that Balarama visited this Temple, bathed in Padmatheertham and made several offerings. Nammalwar, 9th century poet and one among the 12 Vaishnavite saints of the Alvar tradition, has composed ten hymns in praise of Lord Padmanabha.","It is a well known historical fact that Christianity was first introduced into India by St Thomas. After the Death and Resurrection of Christ, Thomas became acquainted with Habban, a merchant of king Gondophare of India. It was in the company of this merchant that Thomas landed at Cranganore on the Malabar Coast of present day Kerala in 52 A.D.","Lord Marundeeswarar is known so because he taught sage Agastya about some magical medicine. Since then the Marundeeswarar temple has been a place of worship for people with diseases and various problems with their health. It is said that even The Sage Valmiki, who wrote The Ramayana, came here to The Marundeeswarar temple to worship The Lord. Sage Valmiki was said to be blessed here. After this incident, this place was to be known as Thiruvalmikiyur, after a long period of time, the name gradually changed to Thiruvanmiyur. There is a place present in Thiruvanmiyur called Valmiki Nagar in his honour.",
            "Ramakrishna Math is a monastic organisation for men brought into existence by Ramakrishna, a 19th-century saint of Bengal. The motto of the Ramakrishna Math and Ramakrishna Mission is: For one's own salvation, and for the welfare of the world","San Thome Basilica is a Roman Catholic minor basilica in Santhome, in the city of Chennai, India. It was built in the 16th century by Portuguese explorers, over the tomb of St Thomas, an apostle of Jesus","Shirdi is famous temple of Shri Sai Baba. It was established in 1922 to carry out the services of Shri Sai Baba.","THIS TEMPLE IS 61ST DIVYA DESAM IN 108 VAISHNAVA DIVYA DESAMS.\n" +
            "\n" +
            "Steeped in mythologies and eulogised by the Azhwars in their sacred hymns in Tamil glorified as Divya Prabandhams the Parthasarathy temple at Tiruvallikkeni or Triplicane, as the Britishers called it, happens to be the oldest temple in the city. The existence of the Tiruvallikeni village is seen in records dating back to the Pallava period and earlier. The village's name itself is derived from Lily pond in front of the temple, where it it said that Goddess Vedavalli, consort of Lord ranganatha, one of the five main deities, was born in a Lily flower. the pond itself was amidst a Tulasi forest(densed with Basil trees). Thus the temple forms the core of the area's history.\n",
            "he Special Entry Darshan(Seeghra Darshanam) is introduced on 21-Sep-2009 to provide quick Darshan to the Pilgrims.\n" +
                    "\n" +
                    "The cost of the Ticket is Rs.300/- per pilgrim with two Laddus free of cost.\n" +
                    "\n" +
                    "The Advance Booking of Special Entry Darshan is introduced w.e.f. 27.August.2014.\n" +
                    "\n" +
                    "Special Entry Darshan tickets can be booked for 09:00 AM (IST) to 03:00 PM (IST) Time Slots.\n" +
                    "\n" +
                    "Pilgrims can avail the Advance Booking of Special Entry Darshan through Internet Booking(www.ttdsevaonline.com), e-Darshan Counters and Indian Post Offices.\n","Vadapalani Andavar Temple is a Hindu temple that is dedicated to Lord Muruga. It is located in Vadapalani, Chennai. It was renovated in the 1920s and a Rajagopuram was built during that time"," The temple was established in 1981 and constructed and congregated in 1982 on the land donated to the temple by Rajah Sir Muthiah Chettiar. The Ayyappa idol, made of Panchaloha (five precious metals representing the five elements of nature), was made by Sri Bhattanachariar, a sculptor from Nagercoil. ",
            "Ranganatha temple on Thiruneermalai in Chennai is a pretty good temple and one must visit if you are a Chennaites. Not much visited by tourists or outsiders. The temple is visited more by local residents. You need walk on steps around (200) to reach the hill top. Nice picturesque view of that part of Chennai from the temple. Some times cool breeze may add value to your visit. This temple is pictured in many a movies of 70's or 80's Tamil Movies.","The temple (approx 900 yrs old) is surrounded by houses and from the main road it doesnt seem that such a big temple can be there.",
            "When we go to an astrologer, somtimes they say Guru is weak in your horoscope, So,you have to go to Guru Bhavans temple, don't worry, Padi Sivan Temple is “Guru’s Stalam, situated very close to Anna Nagar west and very easily accessible from all parts of Chennai via City bus.","This is One of 275 important Siva Devara sthalam. Karumariamman temple is also famous. ","The Periyapalayam Amman (Periyapalathamman) Temple is dedicated to Divine Mother Shakti as Periyapalayam Amman (Periyapalathamman).",":Lord Vishnu who undertook the Narasimha Avataaram at Ahobilam (Andhra Pradesh), once again displayed the Narasimha Avataaram to saptha rishis, who undertook penance at Sholingur. Hence, this is said to be the one of the most sacred of “Divya Desams on the Hill” in Tamil Nadu. "};

    String[] loc={"Near Beach Seashore, Arulmigu Mahalakshmi Temple,\n Besant Nagar, Chennai, Tamil Nadu 600090 \n\bPhone: 044 2446 6777 ","212,Thambu Chetty Street, George Town,\n Opp to High Court,\n Chennai, Tamil Nadu 600001\n" +
            "\bPhone:044 2522 9624"," Coastal Rd, Kalakshetra Colony, Besant Nagar,\n Chennai, Tamil Nadu 600090","12, North Mada Street | Mylapore, Chennai, India\n" +
            "\bPhone Number: 9444327475"," 2, 2nd Main Road, Gandhi Nagar, Adyar, Chennai, Tamil Nadu 600020\n" +
            "\bPhone:044 2441 3995"," Lodge Rd, Little Mount, Saidapet, \nChennai, Tamil Nadu 600015\n" +
            "\bPhone:044 2235 1863","Thiruvanmiyur, Chennai, Tamil Nadu 600041\n" + "Phone: 044 2441 0477","RK Math Road,, Mylapore, Chennai, Tamil Nadu 600004\n" +
            "\bPhone: 044 2462 1110","38, San Thome High Road, Chennai, India\n" +
            "\bPhone Number: +91-044- 2498 5455","Injambakkam, Chennai 600 041, India\n" +
            "\bPhone Number: 044 65684808","Singarachari Street, Triplicane, Chennai 600005, India\n" +
            "Phone Number: 4428442462\n","Venkatnarayana Road, T Nagar | Opposite Thiagaraya Iyer School, Chennai 600017, India\n" +
            "Phone Number: 044-24343535","Andavar Koli Street | Vadapalani, Chennai, India\n" +
            "Phone Number: 04424836903","Thandavarayan Street, Mandavelipakkam, Besant Nagar, Chennai, Tamil Nadu 600028\n" +
            "Phone:044 2493 8239","Thiruneermalai, Chennai 600044, India","Madambakam Bus Stand, Near Tambaram, Chennai, Chennai, India\n" +
            "Phone Number: 22280424-6-12-5-8-30","Easwaran Koil Street, Padi, Thiruvallur District, Chennai, India","Thiruverkadu Devi Karumariamman Temple, Sannadhi Street, Thiruverkadu, Tamil Nadu, India","The Periyapalayam Amman (Periyapalathamman) Temple is located near the Adyar Depot bus stand, Adyar, Chennai.",
            "Sholingur,Near Chennai\n" +
                    "Nearest Station:Arakkonam"      };

    String[] time={"Monday\t9AM–9PM\n" +
            "Tuesday\t\t9AM–9PM\n" +
            "Wednesday\t9AM–9PM\n" +
            "Thursday\t 9AM–9PM\n" +
            "Friday\t \t9AM–9PM\n" +
            "Saturday\t 9AM–9PM\n" +
            "Sunday\t   9AM–9PM","Poojas Offered\tTimings\n" +
            "Kalai sandhi\t6:00 AM To 7:30 AM\n" +
            "Uchi Kalam\t12:00 PM\n" +
            "Sayaratchai\t5:30 PM To 6:00 PM\n" +
            "Artha jamam\t9:00 PM","________"
            ,"All days of the week except Monday\n" +
            "5:30 AM - 12:00 PM\n" +
            "5:00 PM - 09:00 PM","Morning hours:\n" +
            "\n" +
            "03:30 a.m. to 04:45 a.m. (Nirmalya Darshanam)\n" +
            "06:30 a.m. to 07:00 a.m.\n" +
            "8.30 a.m. to 10:00 a.m.\n" +
            "10:30 a.m. to 11:10 a.m.\n" +
            "11:45 a.m. to 12:00 Noon\n" +
            "\n" +
            "Evening hours:\n" +
            "\n" +
            "05:00 p.m. to 06:15 p.m.\n" +
            "06:45 p.m. to 07:20 p.m.","EVERY DAY\n" +
            "6.00. a.m\tAdoration, confession\n" +
            "6.15. a.m.\tHoly Mass\n" +
            "11.30 a.m.\tHoly Mass","Pooja Details:\n" +
            "\n" +
            "The Four Kaala Pooja are conducted according to the Kaarana Nagama Pooja system..\n" +
            "\n" +
            "Kaala Shandhi  Mor 7.30 A.M\n" +
            "\n" +
            "Uchi Kaalam  Mor-10.30 A.M\n" +
            "\n" +
            "Sayartchai   Eve-4.30 P.M\n" +
            "\n" +
            "Ardhajamam  Night-8.30 P.M\n" +
            "\n" +
            "Palliarai Pooja  Night 8.30-9.00 P.M\n" +
            "\n" +
            "Temple Devoting Time Duration:\n" +
            "\n" +
            "Mor 5.00 A.M to Noon 12.00 P.M\n" +
            "\n" +
            "Eve 4.00 P.M to 9.00 P.M","_____","Sun - Sat 6:00 - 20:00","____","____","Special Entry Darshan tickets can be booked for 09:00 AM (IST) to 03:00 PM (IST) Time Slots.","____",
            "____","___" ,"___","5:30 AM - 12:00 PM\n" + "5:00 PM - 09:00 PM","___","\"5:30 AM - 12:00 PM\\n\" + \"5:00 PM - 09:00 PM\"","\"5:30 AM - 12:00 PM\\n\" + \"5:00 PM - 09:00 PM\""};


    String[] web={"http://ashtalakshmitemple.tnhrce.in/","http://www.waytotemple.com/deities/shakthipages/kalikambal","http://www.lordmurugan.com/","http://www.mylaikapaleeswarar.tnhrce.in/","http://www.sreepadmanabhaswamytemple.org/history.htm","http://www.littlemountchurch.org/","http://www.marundeeswarartemple.tnhrce.in/","http://www.chennaimath.org/","http://www.chennai.org.uk/religious-places/churches/basilica-church.html","https://www.shrisaibabasansthan.org/INDEX.HTML","http://www.sriparthasarathytemple.tnhrce.in/","https://www.ttdsevaonline.com/","http://www.vadapalaniandavartemple.tnhrce.in/","https://en.wikipedia.org/wiki/Anna_Nagar_Ayyappan_Koil,_Chennai","https://srirangam.org/",
            "http://temple.dinamalar.com/en/new_en.php?id=34","http://www.padi.co.in/","http://ancientindiantemple.blogspot.in/2007/05/thiruverkadu-and-mangadu-temple-chennai.html","http://www.greenmesg.org/temples_chennai/a/adyar_periyapalayam_amman_temple.php","http://templetherapy.blogspot.in/2012/03/sholinganallursholingur-lakshmi.html"};


    TextView txtPlaceName,txtDesc,txtLoc,txtTime,txtImg;
    int id;
    String placeName;
    ImageButton imgWeb,imgLoc,btnBack;
    Uri uri1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spi_desc);

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
                Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SpiDesc.this,SpiritualNavDrawer.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(SpiDesc.this,SpiritualNavDrawer.class);
        startActivity(intent);
        finish();
    }
}
