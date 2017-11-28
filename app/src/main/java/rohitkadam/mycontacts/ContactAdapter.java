package rohitkadam.mycontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ContactAdapter extends BaseAdapter {
    ArrayList<Contact> contactsList;
    Context context;
    public ContactAdapter(Context context,ArrayList<Contact> contacts){
        this.context=context;
        contactsList=contacts;
    }
    @Override
    public int getCount() {
        return  contactsList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactsList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Contact contact=contactsList.get(position);
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        return view;

    }
}