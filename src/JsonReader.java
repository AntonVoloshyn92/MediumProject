import com.google.api.client.json.Json;
import com.google.gson.Gson;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class JsonReader {

    public static void main(String... args) throws Exception {
        String json =
                "{"
                        + "'title': 'Computing and Information systems',"
                        + "'id' : 1,"
                        + "'children' : 'true',"
                        + "'groups' : [{"
                        + "'title' : 'Level one CIS',"
                        + "'id' : 2,"
                        + "'children' : 'true',"
                        + "'groups' : [{"
                        + "'title' : 'Intro To Computing and Internet',"
                        + "'id' : 3,"
                        + "'children': 'false',"
                        + "'groups':[]"
                        + "}]"
                        + "}]"
                        + "}";

        // Now do the magic.
        Json son = new Json();
        Data data = new Gson().fromJson(new BufferedReader(new InputStreamReader(System.in)), Data.class);

        // Show it.
        System.out.println(data);
    }

}

class Data {
    private String title;
    private Long id;
    private Boolean children;
    private List<Data> groups;

    public String getTitle() { return title; }
    public Long getId() { return id; }
    public Boolean getChildren() { return children; }
    public List<Data> getGroups() { return groups; }

    public void setTitle(String title) { this.title = title; }
    public void setId(Long id) { this.id = id; }
    public void setChildren(Boolean children) { this.children = children; }
    public void setGroups(List<Data> groups) { this.groups = groups; }

    public String toString() {
        return String.format("title:%s\nid:%d\nchildren:%s\ngroups:%s", title, id, children, groups);
    }

    public class Fruits{
        FruitType type;
        int shelfLife;
        XMLGregorianCalendar date;
        double price;
    }

    public enum FruitType{
        BANANA,
        LEMON;
    }
}
