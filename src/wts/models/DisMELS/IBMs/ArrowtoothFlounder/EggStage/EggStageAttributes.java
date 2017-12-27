/*
 * EggStageAttributes
 */

package wts.models.DisMELS.IBMs.ArrowtoothFlounder.EggStage;

import java.util.*;
import java.util.logging.Logger;
import org.openide.util.lookup.ServiceProvider;
import wts.models.DisMELS.framework.AbstractLHSAttributes;
import wts.models.DisMELS.framework.IBMAttributes.IBMAttribute;
import wts.models.DisMELS.framework.IBMAttributes.IBMAttributeBoolean;
import wts.models.DisMELS.framework.IBMAttributes.IBMAttributeDouble;

/**
 * DisMELS class representing attributes for arrowtooth flounder eggs.
* <p>
* The new attributes and keys defined for this class are:
 *  <li> attached - "attached"
 *  <li> sie - "size (cm)"
 *  <li> weight - "weight (kg)"
 *  <li> gonadStage - "gonad stage"
 *  <li> temperature - "temperature deg C"
 *  <li> salinity - "salinity"
 * </ul>
* <p>
 * The complete list of attributes and keys for this class is (in order):
 * <ul>
 *  <li> typeName   - "Life stage type name"
 *  <li> id         - "ID"
 *  <li> parentID   - "Parent ID"
 *  <li> origID     - "Original ID"
 *  <li> startTime  - "Start tie (s)"
 *  <li> time       - "Time (s)"
 *  <li> horizType  - "Horiz. position type"
 *  <li> vertType   - "Vert. position type"
 *  <li> horizPos1  - "Horiz. position 1"
 *  <li> horizPos2  - "Horiz. position 2"
 *  <li> vertPos    - "Vert. position"
 *  <li> gridCellID - "Grid Cell ID"
 *  <li> track      - "track"
 *  <li> active     - "Active status"
 *  <li> alive      - "Alive status"
 *  <li> age        - "Age (d)"
 *  <li> ageInStage - "Age in stage (d)"
 *  <li> number     - "Number of individuals"
 *  <li> attached - "attached"
 *  <li> devStage - "egg development stage"
 *  <li> diameter - "egg diameter"
 *  <li> density  -  "egg density"
 *  <li> temperature - "temperature deg C"
 *  <li> salinity    - "salinity"
 *  <li> rho         - "in situ density"
 * </ul>
 */
@ServiceProvider(service=wts.models.DisMELS.framework.LifeStageAttributesInterface.class)
public class EggStageAttributes extends AbstractLHSAttributes {
    
    //NEW attributes defined by this class
    /** key for "attached" attribute (="attached") */
    public static final String PROP_attached    = "attached";
    /** key for "devStage" attribute (="egg development stage") */
    public static final String PROP_devStage    = "egg development stage";
    /** key for egg "diameter" attribute (="egg diameter") */
    public static final String PROP_diameter    = "egg diameter";
    /** key for egg "density" attribute (="egg density") */
    public static final String PROP_density     = "egg density";
    /** key for in situ "temperature" attribute (="temperature deg C") */
    public static final String PROP_temperature = "temperature deg C";
    /** key for in situ "salinity" attribute (="salinity") */
    public static final String PROP_salinity    = "salinity";
    /** key for in situ water density "rho" attribute (="in situ density") */
    public static final String PROP_rho         = "in situ density";
    
    /** Number of new attributes defined by this class */
    public static final int numNewAttributes = 7;
    /** Total number of attributes defined by this class */
    public static final int numAttributes = AbstractLHSAttributes.numAttributes+numNewAttributes;
    
    /** Set<String> containing keys for NEW attributes for this life stage */
    protected static final Set<String> newKeys = new LinkedHashSet<>((int)(2*numNewAttributes));
    /** Set<String> containing keys for ALL attributes for this life stage */
    protected static final Set<String> keys = new LinkedHashSet<>((int)(2*numAttributes));
    /** Map<String,IBMAttribute> containing map of keys to attributes for ALL attributes for this life stage */
    protected static final Map<String,IBMAttribute> mapAttributes = new HashMap<>((int)(2*numAttributes));
    /** array of Strings, one for each key except "typeName" */
    protected static final String[] aKeys      = new String[numAttributes-1];//does not include typeName
    /** array of Class objects reflecting classes reflecting individual attributes */
    protected static final Class[]  classes    = new Class[numAttributes];
    /** array of Strings to be used as short names for attributes */
    protected static final String[] shortNames = new String[numAttributes];
   
    /** logger for debugging messages */
    private static final Logger logger = Logger.getLogger(EggStageAttributes.class.getName());
    
    /**
     * This constructor is provided only to facilitate the ServiceProvider functionality.
     * DO NOT USE IT!!
     */
    public EggStageAttributes(){
        super("NULL");
        finishInstantiation();
    }
    
    /**
     * Creates a new attributes instance with type name 'typeName'.
     */
    public EggStageAttributes(String typeName) {
        super(typeName);
        finishInstantiation();
    }
    
    /**
     * Returns a deep copy of the instance.  Values are copied.  
     * Any listeners on 'this' are not(?) copied, so these need to be hooked up.
     * @return - the clone.
     */
    @Override
    public Object clone() {
        EggStageAttributes clone = new EggStageAttributes(typeName);
        for (String key: keys) clone.setValue(key,this.getValue(key));
        return clone;
    }

    /**
     * Returns a new instance constructed from the values of the string[].
     * The first value in the string vector must be the type name.
     * Values are set internally by calling setValues(strv) on the new instance.
     * @param strv - vector of values (as Strings) 
     * @return - the new instance
     */
    @Override
    public EggStageAttributes createInstance(final String[] strv) {
        EggStageAttributes atts = new EggStageAttributes(strv[0]);//this sets atts.typeName
        atts.setValues(strv);
        return atts;
    }
    
    private void finishInstantiation(){
        if (newKeys.isEmpty()){
            //set static field information
            mapAttributes.putAll(AbstractLHSAttributes.mapAttributes);//add from superclass
            keys.addAll(AbstractLHSAttributes.keys);//add from superclass
            String key;
            key = PROP_attached;   newKeys.add(key); mapAttributes.put(key,new IBMAttributeBoolean(key,"attached"));
            key = PROP_devStage;   newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"devStage"));
            key = PROP_diameter;   newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"diameter"));
            key = PROP_density;    newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"density"));
            key = PROP_temperature;newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"temperature"));
            key = PROP_salinity;   newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"salinity"));
            key = PROP_rho;        newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"rho"));
            keys.addAll(newKeys);//add new keys from this class
            Iterator<String> it = keys.iterator();
            int j = 0; it.next();//skip typeName
            while (it.hasNext()) aKeys[j++] = it.next();//all keys EXCEPT typeNmae
        }
        //set instance information
        Map<String,Object> tmpMapValues = new HashMap<>((int)(2*numAttributes));
        tmpMapValues.putAll(mapValues);//copy from super
        tmpMapValues.put(PROP_attached,   new Boolean(true));
        tmpMapValues.put(PROP_devStage,   new Double(0));
        tmpMapValues.put(PROP_diameter,   new Double(0));
        tmpMapValues.put(PROP_density,    new Double(0));
        tmpMapValues.put(PROP_temperature,new Double(-1));
        tmpMapValues.put(PROP_salinity,   new Double(-1));
        tmpMapValues.put(PROP_rho,        new Double(-1));
        mapValues = tmpMapValues;//assign to super
    }

    /**
     * Returns the attribute values as an ArrayList (including typeName).
     * 
     * @return 
     */
    @Override
    public ArrayList getArrayList() {
        ArrayList a = super.getArrayList();
        for (String key: newKeys) a.add(getValue(key));
        return a;
    }

    /**
     * Returns the attributes values (not including typeName) as an Object[].
     * 
     * @return 
     */
    @Override
    public Object[] getAttributes() {
        Object[] atts = new Object[numAttributes-1];
        int j = 0;
        Iterator<String> it = keys.iterator();
        it.next();//skip PROP_typeName
        while (it.hasNext()) atts[j++] = getValue(it.next()); 
        return atts;
    }
    
    /**
     * Returns a CSV string representation of the attribute values.
     * 
     *@return - CSV string attribute values
     */
    @Override
    public String getCSV() {
        String str = super.getCSV();//get string from superclass
        Iterator<String> it = newKeys.iterator();
        while (it.hasNext()) str = str+cc+getValueAsString(it.next());//add new attributes
        return str;
    }
                
    /**
     * Returns the comma-delimited string corresponding to the attributes
     * to be used as a header for a csv file.  
     * Use getCSV() to get the string of actual attribute values.
     *
     *@return - String of CSV header names
     */
    @Override
    public String getCSVHeader() {
        String str = super.getCSVHeader();//get header from superclass
        Iterator<String> it = newKeys.iterator();
        while (it.hasNext()) str = str+cc+it.next();//add new attributes
        return str;
    }
                
    /**
     * Returns the comma-delimited string corresponding to the attributes
     * to be used as a header for a csv file.  
     *
     *@return - String of CSV header names (short style)
     */
    @Override
    public String getCSVHeaderShortNames() {
        String str = super.getCSVHeaderShortNames();//get names from superclass
        Iterator<String> it = newKeys.iterator();
        while (it.hasNext()) str = str+cc+mapAttributes.get(it.next()).shortName;//add names for new attributes
        return str;
    }

    /**
     * Returns Class types for all attributes (including typeName) as a Class[] 
     * in the order the keys are defined.
     * 
     * @return - array of Class objects
     */
    @Override
    public Class[] getClasses() {
        if (classes[0]==null){
            int j = 0;
            for (String key: keys){
                classes[j++] = mapAttributes.get(key).getValueClass();
            }
        }
        return classes;
    }

    /**
     * Returns keys for all attributes excluding typeName as a String[]
     * in the order the keys are defined.
     * 
     * @return 
     */
    @Override
    public String[] getKeys() {        
        return aKeys;
    }

    /**
     * Returns short names for all attributes (including typeName) as a String[] 
     * in the order the keys are defined.
     * 
     * @return 
     */
    @Override
    public String[] getShortNames() {
        if (shortNames[0]==null){//do this just once
            int j = 0;
            for (String key: keys){
                shortNames[j++] = mapAttributes.get(key).shortName;
            }
        }
        return shortNames;
    }
    
    /**
     * Sets attribute values to those of input String[].
     * @param strv - String[] of attribute values.
     */
    @Override
    public void setValues(final String[] strv) {
        super.setValues(strv);//set the standard attribute values
        //set the values of the new attributes
        int j = AbstractLHSAttributes.numAttributes;
        try {
            for (String key: newKeys) setValueFromString(key,strv[j++]);
        } catch (java.lang.IndexOutOfBoundsException ex) {
            //@TODO: should throw an exception here that identifies the problem
            String[] aKeys = new String[EggStageAttributes.keys.size()];
            aKeys = EggStageAttributes.keys.toArray(aKeys);
                String str = "Missing attribute value for "+aKeys[j-1]+".\n"+
                             "Prior values are ";
                for (int i=0;i<(j);i++) str = str+strv[i]+" ";
                javax.swing.JOptionPane.showMessageDialog(
                        null,
                        str,
                        "Error setting attribute values:",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                throw ex;
        } catch (java.lang.NumberFormatException ex) {
            String[] aKeys = new String[EggStageAttributes.keys.size()];
            aKeys = EggStageAttributes.keys.toArray(aKeys);
            String str = "Bad attribute value for "+aKeys[j-2]+".\n"+
                         "Value was '"+strv[j-1]+"'.\n"+
                         "Entry was '";
            try {
                for (int i=0;i<(strv.length-1);i++) {
                    if ((strv[i]!=null)&&(!strv[i].isEmpty())) {
                        str = str+strv[i]+", ";
                    } else {
                        str = str+"<missing_value>, ";
                    }
                }
                if ((strv[strv.length-1]!=null)&&(!strv[strv.length-1].isEmpty())) {
                    str = str+strv[strv.length-1]+"'.";
                } else {
                    str = str+"<missing_value>'.";
                }
            }  catch (java.lang.IndexOutOfBoundsException ex1) {
                //do nothing
            }
            javax.swing.JOptionPane.showMessageDialog(
                    null,
                    str,
                    "Error setting attribute values:",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            throw ex;
        }
    }
    
    @Override
    public String getValueAsString(String key){
        Object val = getValue(key);
        IBMAttribute att = mapAttributes.get(key);
        att.setValue(val);
        String str = att.getValueAsString();
        return str;
    }
    
    @Override
    public void setValueFromString(String key, String value) throws NumberFormatException {
        if (!key.equals(PROP_typeName)){
            IBMAttribute att = mapAttributes.get(key);
            att.parseValue(value);
            setValue(key,att.getValue());
        }
    }
}
