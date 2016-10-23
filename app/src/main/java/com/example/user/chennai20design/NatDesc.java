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

public class NatDesc extends AppCompatActivity {

    String[] PlaceName={"Arignar Anna Zoological Park","crocodile","Guindy National Park","Semmozhi Poonga","MGM Dizzee World"," Dakshina Chitra","Cholamandal Artist Village","Muttukadu","Mahabalipuram"
            ,"Sadras"};

    String[] PlaceImage={"giraffe","unnamed","guindy",
            "s","mgm","d","c","m","ma","sa"};

    String[] desc={"Chennai has the distinction of having the first zoo in India, created in 1855. This was shifted from the then Madras City to Vandalur Reserve Forest and a modern Zoological Park was established in 1979 by the Tamil Nadu Forest Department. Spread over 510 ha. of dry evergreen forests with gentle undulating terrain, the specially created open wet and dry island type enclosures with hidden walls and simulated natural environment help the animals, birds and reptiles to feel their natural environment. Chimpanzee, the nearest ancestor to human beings, keeps you busy for a while.","The Madras Crocodile Bank Trust and Centre for Herpetology is one of the largest reptile zoos in the world and one of the oldest non government environmental organizations in Asia.\n" +
            "Our primary aim is to promote the conservation of reptiles and amphibians on the Indian subcontinent, but our inference is multidisciplinary and extends worldwide.","Here’s a national park right in the heart of the city. The park covers 2.82 square kilometers and is home to an impressive number of mammals and insects that are a huge attraction for the children. It’s a pleasant surprise to see this vast array of biodiversity in the heart of the city","overing an area of 20 acres, the Semmozhi Poonga Park is a botanical garden.Overseen by the horticultural department, it is an ideal place to visit in Chennai with family. Apart from the exotic and rare flora grown, there are also some medicinal herbs in the green houses of the park."
            ,"This amusement park, located on the East coast road, is a wholesome entertaining spot for young and old alike. With several thrilling rides and an amphi-theatre for performances, guests to Dizzee World would surely enjoy a day spent here. The water park on the premises has a wave pool apart from many other rides and slides.","This is one of the places to visit in Chennai with kids where they will be introduced to the South Indian culture of the past. Literally translating to ‘a picture of the south’,DakshinaChitra is a small village has been recreated using replicas of traditional South Indian houses dating back to the 19th and 20th centuries.","This artists’ commune is a platform for the resident painters and sculptors to showcase their creations to the visiting guests. Located on the fringes of Chennai, in the village of Injambakkam, Cholamandal has two galleries, an open-air theatre, a book store and a craft shop. For those interested in art and craft, this destination with a serene ambience will be an ideal outing."
            ,"A backwater area of the Bay of Bengal, Muttukadu is one of the tourist places near Chennai where one can get to indulge in water sports. With its extensive facilities, that include a restaurant, and a large number of boats, it can host visitors throughout the year.\n" +
            "\n" +
            "Distance: 31 km","Famed for its ancient mountains, Mahabalipuram, also known as Mamallapuram, is one of the places to visit near Chennai. Placed around 60 km south from the city of Chennai, it was once a busy seaport during the dynasty of the Pallavas.\n" +
            "\n" +
            "Distance: 52 km","The coastal town of Sadras was once a Dutch fortress which was taken over by the British in later years. It is currently in ruins but a few structures within can still be viewed."};

    String[] loc={"Vandalur, Chennai 600048, India\n" +
            "Phone Number: 044-22751089","Post Bag No 4, Mahabalipuram, Tamil Nadu 603104\n" +
            "phone no: 044 2747 2447","Guindy Raj Bhawan | 259 Anna Salai, DMS Compound, Teynampet, Chennai, India\n" +
            "Phone Number: +91-44-24321471"
            ,"Ellaiamman Colony, Teynampet, Chennai, Tamil Nadu 600086" ,"No:1/74,East Coast Road, Muttukadu,, Chennai, Tamil Nadu 600112","East Coast Road, Muttukadu, Chengalpet, Tamil Nadu 603118","10am to 6 pm. Weekly holiday: Tuesday (open on all national holidays except on Diwali day).","E Coast Rd, Cholamandal Artists Village, Injambakkam, Palavakkam, Tamil Nadu 600115\n" +
            "Phone:044 2449 0092","Eastern coast, South of Chennai"," Eastern coast, South of Chenna","Eastern coast, South of Mahabalipuram"};

    String[] time={"All days of the week except Tuesday\n" +
            "9:00 AM - 5:00 PM","Tuesday to sunday\n" +
            "08:30 am to 05:30 pm\n"+
            "closed on mondays","All of the week except Tuesday\n" +
            "09:00 AM-5:30 PM","The Semmozhi Poonga on Cathedral Road will be open for use by morning walkers from Wednesday between 6 a.m. and 8 a.m. For others, the park will be open between 10 a.m. and 8 p.m.","9:30 am to 5:30 pm on weekdays, 10:30 am to 7:30 pm on weekends and holidays","9:00 AM - 6:30 PM","Best time to visit: November to March","Best time to visit: November to March","Best time to visit: October to March"};

    String[] web={"https://www.ixigo.com/arignar-anna-zoological-park-chennai-india-opening-visiting-timing-hours-closed-days-ne-1700298","http://www.madrascrocodilebank.org/cms/plan-your-visit/timings-and-rate-card/","https://www.ixigo.com/guindy-national-park-chennai-india-opening-visiting-timing-hours-closed-days-ne-1282970","https://www.ixigo.com/semmozhi-poonga-chennai-india-opening-visiting-timing-hours-closed-days-ne-1312394","http://www.mgmdizzeeworld.com/","http://dakshinachitra.net/visit","https://www.ixigo.com/cholamandal-artists-village-chennai-india-opening-visiting-timing-hours-closed-days-ne-1700305","http://www.chennai.org.uk/excursions/muttukadu.html","http://www.mahabalipuram.co.in/"
            ,"https://www.tripadvisor.in/ShowUserReviews-g503705-d3187602-r203997678-Dutch_Fort-Kanchipuram_Tamil_Nadu.html"};
    TextView txtPlaceName,txtDesc,txtLoc,txtTime,txtImg;
    int id;
    String placeName;
    ImageButton imgWeb,imgLoc,btnBack;
    Uri uri1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nat_desc);

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
                Intent intent=new Intent(NatDesc.this,NatParkNavDrawer.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(NatDesc.this,NatParkNavDrawer.class);
        startActivity(intent);
        finish();
    }
}
