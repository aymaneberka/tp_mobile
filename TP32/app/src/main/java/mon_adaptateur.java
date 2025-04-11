import java.util.ArrayList;

public class mon_adaptateur {
    ArrayList<Logiciel> listlog;
    // inf: un objet permettant de convertir les éléments d'un fichier
    layout XML à un nouvel objet de type View .
            LayoutInflater inf;
    //Constructeur
    public mon_adaptateur(@NonNull Context context, int resource,
                       @NonNull  ArrayList<logiciels> lslog) {
        2
    }
super(context, resource, lslog);
this.listlog = lslog;
this.inf = LayoutInflater.from(context);
    @NonNull
    @Override
//méthode getView
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
//accéder au fichier XML (design de item) et d'en récupérer la vue:
        convertView = inf.inflate(R.layout.item_modele, null);
//récupérer les composants de layout
        TextView titre = convertView.findViewById(R.id.titre);
        TextView desp = convertView.findViewById(R.id.description);
        ImageView img = convertView.findViewById(R.id.logo);
        desp.setText(listlog.get(position).getDesscription());
        titre.setText(listlog.get(position).getTitre());
        img.setImageResource(listlog.get(position).getLogiciel());
        return convertView;
    }
}
