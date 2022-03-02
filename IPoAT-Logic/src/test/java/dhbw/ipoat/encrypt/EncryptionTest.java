package dhbw.ipoat.encrypt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EncryptionTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void doEncryption() {

        //Arrange
        String teststring = "Peter Pettigrew";
        String result;

        //Act
        result = Encryption.doEncryption(teststring);
        System.out.println(result);
        result = Encryption.doDecrypting(result);

        //Assert
        assertTrue(teststring.equals(result));

    }

    @Test
    public void doDecrypting() {
        String teststring = "1107100801010214010204061009021113131307100713071011070710070604071201021111080910070205050808130201011301131204021106100803140104080614010602020701071104021209131012141206130103021408140706080105100803080912120201020607121309061310080901030311101411040706011205090103030401110106061205140106110103141302081208141008030203111306020708040810020104100601091001130110100508110703130811131211010205080414111302130807090504060903141309101411050813090406040404060112031011110104140713070604080301141203080902131001071408110511010809050113101304061406060614140501010909130909030212140502140105050106070402021104041212080305130202140902110711100909100605120505070603060207050706090603131402110305020202121410081101090604020405050711030914090706130405090610050107050901140206030605120710011302041114140613090609111011110612020904051011020412070601101406091302050706090107051101090513140309060203061010091011070812011405040811090501121214040207011201071307061312071212101303021110051106050806120602060408140106140403020607140104130211061304130908100503130608021108100609070704120206140810081306020307120910011407081411021206110412120305110108071111090209101311090414081204031303110214071114011307130302090808040201011105140509021010031003051302110803121313021203010305130401141203021212030107040809121013030204081402071013071309130303141307020702120102070503120313050410030214031409030510110206110402080609031310140712141108080701020206100313061104010210120310050110010707070909050212030614040910010901010207070905120112020408040103081413080512010610011108050907080802040306130108121206010302121212141314021113041209020701141110090413141408120507070202121304011007021101141214090512101408010409121308080106140405060305080809041011141112030712131105050808140803071304010810120413060204090902140702060114141007020213040709080901090212140804080212130401010206060514080609010603021404121405090703071103130912061207030301070613030914031204120713010912011211101101041004091201021108060201141104020113071314081206090410061408040513010105070609020412140609051002031210040212030105021411110710011214060909111004110101010110011411071306080109130213081310020612061401050614020701061203101306060406070312060809051008080811141002031012030804070502020801121301101111130710101107060301031203080805070514021102070406070410010509140413081007031013080201060408010313100812050402030305070914091110110612130201141206120801060414130809030410101414090309131411091305130208010706100509030606030114091411090314130914090507100813060107091110141109070406041207140407020912110314100612031412120104010514011411051401140304010206030201050408010504060204111308090402020113071014020603070214021406080314100114021306061107080203050412061203130702020202060813100714140813050505010802130809020211080411101005011207101203130809020101061111070410120608030104020307111311130206120601111408031005010709130810080206050305080707141403061310040504021214031412011209070807021004040211130414060303070304041207080408130505021001030214130714130612090107020413040106030607071114030908070209110510041413081312101313040513080114091311040309080611031006050103050711080703140706140504010608050510080112100707030713041214030610060511041406081014081408120401130108020514030711060412050102100710010202060414100714080506091110110406041109131304060202021113111313131104051211100313051410090514090607051102010707100906070710040604110210101413010114100601021205090210120110121111011408121005120206050205061205080412070813061010011306040901141202071112061105070914010212121010061212020109061403041301051409120407060912040701010605140212100305140902110410140609020202060903030210071212030109061208061013021410061108081008090205031205060512091306090807030108130614101413021213011313051413040413081003100308100511041403111001070212131004031113080712050414140212050407041307020208061403130408070610050112141006120406050110071106101209110209090104140108010705090210050913090513080404021313130807101202021003011210020801030705120309041314110107110403041010130903070509141004090702011414100912010206071310100501130304121214091201070309110111091114090910141212121103050210131408130504081305121214131408130504050408030805051208130505";
        String result;

        result = Encryption.doDecrypting(teststring);
        System.out.println(result);
        result = Encryption.doEncryption(result);

        assertNotEquals(teststring, result);
    }
}