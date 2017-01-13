package bestpractices.keyoutcomestracker.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import bestpractices.keyoutcomestracker.R;

public class FragmentAdditionalResources extends Fragment {

    RelativeLayout excelRelativeLayout;
    RelativeLayout pdfRelativeLayout;
    RelativeLayout androidRelativeLayout;
    RelativeLayout appleRelativeLayout;
    RelativeLayout windowsRelativeLayout;
    RelativeLayout nookRelativeLayout;
    RelativeLayout kindleRelativeLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
        final View view = inflater.inflate(R.layout.fragment_additional_resources, container, false);

        excelRelativeLayout = (RelativeLayout) view.findViewById(R.id.excelRelativeLayout);
        pdfRelativeLayout = (RelativeLayout) view.findViewById(R.id.pdfRelativeLayout);
        androidRelativeLayout = (RelativeLayout) view.findViewById(R.id.androidRelativeLayout);
        appleRelativeLayout = (RelativeLayout) view.findViewById(R.id.appleRelativeLayout);
        windowsRelativeLayout = (RelativeLayout) view.findViewById(R.id.windowsRelativeLayout);
        nookRelativeLayout = (RelativeLayout) view.findViewById(R.id.nookRelativeLayout);
        kindleRelativeLayout = (RelativeLayout) view.findViewById(R.id.kindleRelativeLayout);




        excelRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://nebula.wsimg.com/41558b65a19e2e464922412965057cf5?AccessKeyId=BCB327F7A8B1E630C660&amp;disposition=0&amp;alloworigin=1"));
                startActivity(intent);




            }
        });

        pdfRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://nebula.wsimg.com/b8b2a35726c6913634e48b896a88ca15?AccessKeyId=BCB327F7A8B1E630C660&disposition=0&alloworigin=1"));
                startActivity(intent);

            }
        });

        androidRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/books/details/Kevin_J_Barry_Succeeding_In_College_Dos_and_Don_ts?id=M_NTCAAAQBAJ&hl=en"));
                startActivity(intent);

            }
        });

        appleRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://itunes.apple.com/us/book/succeeding-in-college-dos/id987128022?mt=11"));
                startActivity(intent);

            }
        });

        windowsRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.smashwords.com/books/search?query=succeeding+in+college"));
                startActivity(intent);

            }
        });

        nookRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.barnesandnoble.com/w/succeeding-in-college-kevin-barry/1121801053?ean=2940151883993"));
                startActivity(intent);
            }
        });

        kindleRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.amazon.com/gp/product/B016CJLLNM"));
                startActivity(intent);
            }
        });

        return view;
    }

}
