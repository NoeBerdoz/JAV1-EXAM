package ch.ansermgw.angryword.provider;

import ch.ansermgw.angryword.AngrywordMain;
import ch.ansermgw.angryword.activities.Play;
import ch.ansermgw.angryword.models.Language;
import ch.ansermgw.angryword.models.SemanticWord;
import ch.ansermgw.angryword.resource.VocabularyResource;
import ch.ansermgw.angryword.resource.WordResource;
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.List;

public class VocabularyProvider {
    private static VocabularyProvider instance;
    private final List<VocabularyResource> vocabularies;
    private final List<Language> languages;

    private VocabularyProvider() {
        vocabularies = new ArrayList<>();
        languages = new ArrayList<>();
        SemanticWord sw;
        Language fr = new Language("Français", "fr");
        Language en = new Language("Anglais", "en");
        Language es = new Language("Espagnol", "es");

        languages.add(fr);
        languages.add(en);
        languages.add(es);

        VocabularyResource voc = new VocabularyResource("l'argent");
        // WordResource word;

        try {
            sw = new SemanticWord(); sw.addTranslation(fr,"la banque"); sw.addTranslation(en,"the bank"); sw.addTranslation(es,"el Banco"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"l''argent liquide"); sw.addTranslation(en,"cash"); sw.addTranslation(es,"efectivo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"le paiement"); sw.addTranslation(en,"payment"); sw.addTranslation(es,"pago"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un carnet de chèques"); sw.addTranslation(en,"checkbook"); sw.addTranslation(es,"talonario de cheques"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"déposer de l''argent"); sw.addTranslation(en,"to deposit money"); sw.addTranslation(es,"depositar dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"prêter de l''argent"); sw.addTranslation(en,"to borrow money"); sw.addTranslation(es,"pedir dinero prestado"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"les services financiers"); sw.addTranslation(en,"financial services"); sw.addTranslation(es,"servicios financieros"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"la commission"); sw.addTranslation(en,"commission"); sw.addTranslation(es,"comisión"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un investissement"); sw.addTranslation(en,"an investment"); sw.addTranslation(es,"una inversión"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un virement"); sw.addTranslation(en,"transfer"); sw.addTranslation(es,"transferir"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"la gestion de l''argent"); sw.addTranslation(en,"money management"); sw.addTranslation(es,"administración del dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"une transaction"); sw.addTranslation(en,"a transaction"); sw.addTranslation(es,"una transacción"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un guichet automatique"); sw.addTranslation(en,"ATM machine"); sw.addTranslation(es,"cajero automático"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"attendre dans la queue"); sw.addTranslation(en,"to wait in line"); sw.addTranslation(es,"a esperar en línea"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"une carte bancaire"); sw.addTranslation(en,"banking/ATM card"); sw.addTranslation(es,"tarjeta bancaria / ATM"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"faire des économies"); sw.addTranslation(en,"to save money"); sw.addTranslation(es,"para ahorrar dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"le montant"); sw.addTranslation(en,"sum/total amount"); sw.addTranslation(es,"suma / monto total"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un compte-chèques"); sw.addTranslation(en,"checking account"); sw.addTranslation(es,"cuenta de cheques"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"l''argent"); sw.addTranslation(en,"money"); sw.addTranslation(es,"dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"les fonds"); sw.addTranslation(en,"funds"); sw.addTranslation(es,"fondos"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un chèque"); sw.addTranslation(en,"check"); sw.addTranslation(es,"cheque"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un dépôt"); sw.addTranslation(en,"deposit"); sw.addTranslation(es,"depositar"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"le crédit"); sw.addTranslation(en,"credit"); sw.addTranslation(es,"crédito"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"les marchés financiers"); sw.addTranslation(en,"financial markets"); sw.addTranslation(es,"mercados financieros"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"la clientèle"); sw.addTranslation(en,"clientele"); sw.addTranslation(es,"clientela"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"les frais"); sw.addTranslation(en,"fees"); sw.addTranslation(es,"Tarifa"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"une institution financière"); sw.addTranslation(en,"financial institution"); sw.addTranslation(es,"institución financiera"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"le taux d''intérêt"); sw.addTranslation(en,"interest rate"); sw.addTranslation(es,"tasa de interés"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"la monnaie"); sw.addTranslation(en,"currency"); sw.addTranslation(es,"moneda"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"le bilan"); sw.addTranslation(en,"balance"); sw.addTranslation(es,"equilibrar"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"prendre un numéro"); sw.addTranslation(en,"to take a number"); sw.addTranslation(es,"tomar un número"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"une carte de crédit"); sw.addTranslation(en,"credit card"); sw.addTranslation(es,"tarjeta de crédito"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un emprunt"); sw.addTranslation(en,"a loan"); sw.addTranslation(es,"un préstamo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"retirer de l''argent"); sw.addTranslation(en,"to take out money"); sw.addTranslation(es,"sacar dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un compte d''épargne"); sw.addTranslation(en,"savings account"); sw.addTranslation(es,"cuenta de ahorros"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un distributeur automatique"); sw.addTranslation(en,"ATM machine"); sw.addTranslation(es,"cajero automático"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(fr,"un reçu"); sw.addTranslation(en,"receipt"); sw.addTranslation(es,"recibo"); voc.addSemanticWord(sw);
        } catch (Exception e) {

        }

        vocabularies.add(voc);

    }

    public static VocabularyProvider getInstance() {
        if (instance == null)
            VocabularyProvider.instance = new VocabularyProvider();

        return instance;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public VocabularyResource getRandomVocabulary() {
        return vocabularies.get(AngrywordMain.getInstance().getRandom().nextInt(vocabularies.size()));
    }

}
