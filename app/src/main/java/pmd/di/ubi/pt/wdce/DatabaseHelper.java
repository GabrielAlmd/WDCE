package pmd.di.ubi.pt.wdce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "Login.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, user text, password text, score intege, level integer)");
        //db.execSQL("Create table dic(word text primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        //db.execSQL("drop table if exists dic");
    }

    //inserir na user
    public boolean insert (String email, String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("user", user);
        contentValues.put("password", password);
        contentValues.put("score", 0);
        contentValues.put("level",0);
        long ins = db.insert("user", null, contentValues);
        if(ins == -1)
            return false;
        else
            return true;
    }

    //check if mail exists
    public boolean chkemail (String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //check if user exists
    public boolean chkuser (String user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where user=?", new String[]{user});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //check password
    public boolean chkpass (String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where password=?", new String[]{password});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }


    //check the user and password
    public boolean match (String user, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where user=? and password=?", new String[]{user, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    /*
    public boolean addpoints (String user, int points){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where user=?", new String[]{user});
        if(cursor.getCount()>0) {
            db.rawQuery("")
            return true;
        }
        else
            return false;
    }*/


    //insere na dic
    /*
    public boolean insertword (){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("word","Aardvark");
        contentValues.put("word","Abelha");
        contentValues.put("word","Águia");
        contentValues.put("word","Alce");
        contentValues.put("word","Andorinha");
        contentValues.put("word","Anta");
        contentValues.put("word","Antílope");
        contentValues.put("word","Aranha");
        contentValues.put("word","Áustria");
        contentValues.put("word","Índia");
        contentValues.put("word","Afeganistão");
        contentValues.put("word","Albânia");
        contentValues.put("word","Alemanha");
        contentValues.put("word","Andorra");
        contentValues.put("word","Angola");
        contentValues.put("word","Anguila");
        contentValues.put("word","Antárctida");
        contentValues.put("word","Argélia");
        contentValues.put("word","Argentina");
        contentValues.put("word","Arménia");
        contentValues.put("word","Aruba");
        contentValues.put("word","Austrália");
        contentValues.put("word","Azerbaijão");
        contentValues.put("word","abajur");
        contentValues.put("word","abre-latas");
        contentValues.put("word","açucareiro");
        contentValues.put("word","agulha");
        contentValues.put("word","alfinete");
        contentValues.put("word","algema");
        contentValues.put("word","alicate");
        contentValues.put("word","almofada");
        contentValues.put("word","âncora");
        contentValues.put("word","anel");
        contentValues.put("word","antena");
        contentValues.put("word","anzol");
        contentValues.put("word","apagador");
        contentValues.put("word","apito");
        contentValues.put("word","apontador");
        contentValues.put("word","aquecedor");
        contentValues.put("word","arco");
        contentValues.put("word","aro");
        contentValues.put("word","aspirador");
        contentValues.put("word","azulejo");
        contentValues.put("word","Ave-lira");
        contentValues.put("word","Avestruz");
        contentValues.put("word","Babuíno");
        contentValues.put("word","Baleia");
        contentValues.put("word","Barata");
        contentValues.put("word","Bisão");
        contentValues.put("word","Boi");
        contentValues.put("word","Borboleta");
        contentValues.put("word","Burro");
        contentValues.put("word","Bélgica");
        contentValues.put("word","Baamas");
        contentValues.put("word","Bangladeche");
        contentValues.put("word","Barém");
        contentValues.put("word","Barbados");
        contentValues.put("word","Belize");
        contentValues.put("word","Benim");
        contentValues.put("word","Bermudas");
        contentValues.put("word","Bielorrússia");
        contentValues.put("word","Birmânia");
        contentValues.put("word","Bolívia");
        contentValues.put("word","Botsuana");
        contentValues.put("word","Brasil");
        contentValues.put("word","Brunei");
        contentValues.put("word","bacia");
        contentValues.put("word","balança");
        contentValues.put("word","banco");
        contentValues.put("word","bengala");
        contentValues.put("word","berço");
        contentValues.put("word","berimbau");
        contentValues.put("word","bicicleta");
        contentValues.put("word","bidê");
        contentValues.put("word","bigorna");
        contentValues.put("word","binóculo");
        contentValues.put("word","biruta");
        contentValues.put("word","bisturi");
        contentValues.put("word","boia");
        contentValues.put("word","bola");
        contentValues.put("word","boneca");
        contentValues.put("word","borracha");
        contentValues.put("word","botão");
        contentValues.put("word","brinco");
        contentValues.put("word","bule");
        contentValues.put("word","bumerangue");
        contentValues.put("word","Bulgária");
        contentValues.put("word","Burúndi");
        contentValues.put("word","Butão");
        contentValues.put("word","Cabra");
        contentValues.put("word","Cação");
        contentValues.put("word","Camelo");
        contentValues.put("word","Canguru");
        contentValues.put("word","Cão");
        contentValues.put("word","Caracol");
        contentValues.put("word","Caranguejo");
        contentValues.put("word","Carneiro");
        contentValues.put("word","Castor");
        contentValues.put("word","Cavalo");
        contentValues.put("word","Cefo");
        contentValues.put("word","Chacal");
        contentValues.put("word","Chimpanzé");
        contentValues.put("word","Cisne");
        contentValues.put("word","Cobra");
        contentValues.put("word","Coelho");
        contentValues.put("word","Coiote");
        contentValues.put("word","Cormorão");
        contentValues.put("word","Coruja");
        contentValues.put("word","Corvo");
        contentValues.put("word","Corvo");
        contentValues.put("word","Cotovia");
        contentValues.put("word","Crocodilo");
        contentValues.put("word","Cudu");
        contentValues.put("word","cabide");
        contentValues.put("word","cadeado");
        contentValues.put("word","cadeira");
        contentValues.put("word","caderno");
        contentValues.put("word","cajado");
        contentValues.put("word","cálice");
        contentValues.put("word","caneta");
        contentValues.put("word","canivete");
        contentValues.put("word","capa");
        contentValues.put("word","capacete");
        contentValues.put("word","castiçal");
        contentValues.put("word","cata-vento");
        contentValues.put("word","celular");
        contentValues.put("word","chicote");
        contentValues.put("word","chinelo");
        contentValues.put("word","chupeta");
        contentValues.put("word","clipe");
        contentValues.put("word","colchão");
        contentValues.put("word","colher");
        contentValues.put("word","copo");
        contentValues.put("word","Camarões");
        contentValues.put("word","Camboja");
        contentValues.put("word","Canadá");
        contentValues.put("word","Catar");
        contentValues.put("word","Cazaquistão");
        contentValues.put("word","Chade");
        contentValues.put("word","Chile");
        contentValues.put("word","China");
        contentValues.put("word","Chipre");
        contentValues.put("word","Colômbia");
        contentValues.put("word","Comores");
        contentValues.put("word","Congo-Brazzaville");
        contentValues.put("word","Congo-Kinshasa");
        contentValues.put("word","Croácia");
        contentValues.put("word","Cuba");
        contentValues.put("word","Doninha");
        contentValues.put("word","Dinamarca");
        contentValues.put("word","Domínica");
        contentValues.put("word","Dragão-de-Komodo");
        contentValues.put("word","Dugongo");
        contentValues.put("word","Elefante");
        contentValues.put("word","Enguia");
        contentValues.put("word","Équidnas");
        contentValues.put("word","Esquilo");
        contentValues.put("word","Estrela-do-mar");
        contentValues.put("word","Egipto");
        contentValues.put("word","Equador");
        contentValues.put("word","Eritreia");
        contentValues.put("word","Eslováquia");
        contentValues.put("word","Eslovénia");
        contentValues.put("word","Espanha");
        contentValues.put("word","Estónia");
        contentValues.put("word","Etiópia");
        contentValues.put("word","Falcão");
        contentValues.put("word","Foca");
        contentValues.put("word","Formiga");
        contentValues.put("word","Frango");
        contentValues.put("word","Fuinha");
        contentValues.put("word","Furão");
        contentValues.put("word","Fiji");
        contentValues.put("word","Filipinas");
        contentValues.put("word","Finlândia");
        contentValues.put("word","França");
        contentValues.put("word","Gâmbia");
        contentValues.put("word","Gabão");
        contentValues.put("word","Gana");
        contentValues.put("word","Geórgia");
        contentValues.put("word","Gibraltar");
        contentValues.put("word","Grécia");
        contentValues.put("word","Granada");
        contentValues.put("word","Gronelândia");
        contentValues.put("word","Guadalupe");
        contentValues.put("word","Guame");
        contentValues.put("word","Guatemala");
        contentValues.put("word","Guiana");
        contentValues.put("word","Guiné");
        contentValues.put("word","Guiné-Bissau");
        contentValues.put("word","Gaivota");
        contentValues.put("word","Ganso");
        contentValues.put("word","Garça-real");
        contentValues.put("word","Gato");
        contentValues.put("word","Gauro");
        contentValues.put("word","Gazela");
        contentValues.put("word","Gerbilo");
        contentValues.put("word","Girafa");
        contentValues.put("word","Gnu");
        contentValues.put("word","Golfinho");
        contentValues.put("word","Gorila");
        contentValues.put("word","Guanaco");
        contentValues.put("word","Guaxinim");
        contentValues.put("word","Hamster");
        contentValues.put("word","Hiena");
        contentValues.put("word","Hipopótamo");
        contentValues.put("word","Iaque");
        contentValues.put("word","Iguana");
        contentValues.put("word","Jacaré");
        contentValues.put("word","Jaguar");
        contentValues.put("word","Javali");
        contentValues.put("word","Kouprey");
        contentValues.put("word","Lagarta");
        contentValues.put("word","Lagarto");
        contentValues.put("word","Lagosta");
        contentValues.put("word","Leão");
        contentValues.put("word","Lebre");
        contentValues.put("word","Lémure");
        contentValues.put("word","Leopardo");
        contentValues.put("word","Lhama");
        contentValues.put("word","Libélula");
        contentValues.put("word","Lobo");
        contentValues.put("word","Lontra");
        contentValues.put("word","Loris");
        contentValues.put("word","Lula");
        contentValues.put("word","Macaco");
        contentValues.put("word","Medusa");
        contentValues.put("word","Morcego");
        contentValues.put("word","Morsa");
        contentValues.put("word","Mosca");
        contentValues.put("word","Mosquito");
        contentValues.put("word","Mula");
        contentValues.put("word","Musaranho");
        contentValues.put("word","Naja");
        contentValues.put("word","Ocapi");
        contentValues.put("word","Órix");
        contentValues.put("word","Ostra");
        contentValues.put("word","Ouriço");
        contentValues.put("word","Pantera");
        contentValues.put("word","Papa-formigas");
        contentValues.put("word","Pato");
        contentValues.put("word","Pato-real");
        contentValues.put("word","Pavão");
        contentValues.put("word","Pega");
        contentValues.put("word","Peixe-boi");
        contentValues.put("word","Pelicano");
        contentValues.put("word","Perdiz");
        contentValues.put("word","Perú");
        contentValues.put("word","Piolho");
        contentValues.put("word","Pomba");
        contentValues.put("word","Pombo");
        contentValues.put("word","Pónei");
        contentValues.put("word","Porco");
        contentValues.put("word","Porco-espinho");
        contentValues.put("word","Porquinho-da-índia");
        contentValues.put("word","Puma");
        contentValues.put("word","Palau");
        contentValues.put("word","Panamá");
        contentValues.put("word","Paquistão");
        contentValues.put("word","Paraguai");
        contentValues.put("word","Peru");
        contentValues.put("word","Pitcairn");
        contentValues.put("word","Polónia");
        contentValues.put("word","Portugal");
        contentValues.put("word","quadriciclo");
        contentValues.put("word","quadro");
        contentValues.put("word","quadro negro");
        contentValues.put("word","quebra-cabeça");
        contentValues.put("word","quebra-nozes");
        contentValues.put("word","queijeira");
        contentValues.put("word","quepe");
        contentValues.put("word","quimono");
        contentValues.put("word","Raposa");
        contentValues.put("word","Ratazana");
        contentValues.put("word","Rato");
        contentValues.put("word","Rena");
        contentValues.put("word","Rinoceronte");
        contentValues.put("word","Rouxinol");
        contentValues.put("word","Salamandra");
        contentValues.put("word","Sapo");
        contentValues.put("word","Serpente");
        contentValues.put("word","Suricata");
        contentValues.put("word","Tarsius");
        contentValues.put("word","Tartaruga");
        contentValues.put("word","Tatu");
        contentValues.put("word","Tentilhão");
        contentValues.put("word","Texugo");
        contentValues.put("word","Tigre");
        contentValues.put("word","Toupeira");
        contentValues.put("word","Tubarão");
        contentValues.put("word","Uapiti");
        contentValues.put("word","Urso");
        contentValues.put("word","ukulele");
        contentValues.put("word","ultraleve");
        contentValues.put("word","umbral");
        contentValues.put("word","umidificador");
        contentValues.put("word","unha postiça");
        contentValues.put("word","uniforme");
        contentValues.put("word","urinol");
        contentValues.put("word","urna");
        contentValues.put("word","Veado");
        contentValues.put("word","Vespa");
        contentValues.put("word","Vespão");
        contentValues.put("word","Vison");
        contentValues.put("word","wafer");
        contentValues.put("word","walkie-talkie");
        contentValues.put("word","walkman");
        contentValues.put("word","webcam");
        contentValues.put("word","xadrez");
        contentValues.put("word","xale");
        contentValues.put("word","xampu");
        contentValues.put("word","xarope");
        contentValues.put("word","xequerê");
        contentValues.put("word","xícara");
        contentValues.put("word","xilofone");
        contentValues.put("word","xilogravura");
        contentValues.put("word","yacht");
        contentValues.put("word","yagi");
        contentValues.put("word","yen");
        contentValues.put("word","Zebra");
        contentValues.put("word","Zâmbia");
        contentValues.put("word","Zimbabué");
        contentValues.put("word","zabumba");
        contentValues.put("word","zambê");
        contentValues.put("word","zarabatana");
        contentValues.put("word","zinco");
        contentValues.put("word","zíper");
        long ins = db.insert("dic",null,contentValues);
        if(ins == -1)
            return false;
        else
            return true;
    }*/

}
