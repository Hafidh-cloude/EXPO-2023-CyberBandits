package DataBase;

import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import HalamanUtama.SampahB3.DataItem3;
import javafx.collections.ObservableList;

@XStreamAlias("InfoSampah")
public class AlldataSampah {
    
    @XStreamImplicit
    private ArrayList<KumpulanSampah> allSampah = new ArrayList<>();

    public ArrayList<KumpulanSampah> getsampahall() {
        return allSampah;
    }

    public void setsampahall(ArrayList<KumpulanSampah> allSampah) {
        this.allSampah = allSampah;
    }

    public ObservableList<DataItem3> getData() {
        return null;
    }

}
