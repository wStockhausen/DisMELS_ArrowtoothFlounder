/*
 * AbstractArrowtoothAttributes.java
 */

package wts.models.DisMELS.IBMs.ArrowtoothFlounder;

import java.util.*;
import wts.models.DisMELS.framework.AbstractLHSAttributes;
import wts.models.DisMELS.framework.IBMAttributes.*;
import wts.models.DisMELS.framework.LifeStageAttributesInterface;

/**
 * Abstract class for DisMELS arrowtooth flounder larva, settler, and benthic 
 * juvenile life stage attributes classes. These three classes all have the same 
 * attributes, and so can extend this class rather simply.
 * <p>
 * The new attributes and keys defined by this abstract class are:
 * <ul>
 *  <li> attached - "attached"
 *  <li> size - "size (cm)"
 *  <li> weight - "weight (kg)"
 *  <li> temperature - "temperature deg C"
 *  <li> salinity - "salinity"
 * </ul>
* <p>
 * The complete list of attributes and keys for this abstract class are (in order):
 * <ul>
 *  <li> typeName - "Life stage type name"
 *  <li> id - "ID"
 *  <li> parentID - "Parent ID"
 *  <li> origID - "Original ID"
 *  <li> startTime - "Start tie (s)"
 *  <li> time - "Time (s)"
 *  <li> horizType - "Horiz. position type"
 *  <li> vertType - "Vert. position type"
 *  <li> horizPos1 - "Horiz. position 1"
 *  <li> horizPos2 - "Horiz. position 2"
 *  <li> vertPos - "Vert. position"
 *  <li> gridCellID - "Grid Cell ID"
 *  <li> track - "track"
 *  <li> active - "Active status"
 *  <li> alive - "Alive status"
 *  <li> age - "Age (d)"
 *  <li> ageInStage - "Age in stage (d)"
 *  <li> number - "Number of individuals"
 *  <li> attached - "attached"
 *  <li> size - "size (cm)"
 *  <li> weight - "weight (kg)"
 *  <li> temperature - "temperature deg C"
 *  <li> salinity - "salinity"
 * </ul>
 */
public abstract class AbstractArrowtoothAttributes extends AbstractLHSAttributes {
    
    //NEW attributes defined by this class
    /** key for the attribute reflecting whether individual is attached to bottom (="attached") */
    public static final String PROP_attached    = "attached";
    /** key for the attribute reflecting individual size (="size (cm)") */
    public static final String PROP_size        = "size (cm)";
    /** key for the attribute reflecting individual weight (="weight (kg)") */
    public static final String PROP_weight      = "weight (kg)";
    /** key for attribute reflecting in situ "temperature" (="temperature deg C") */
    public static final String PROP_temperature = "temperature deg C";
    /** key for attribute reflecting in situ "salinity" (="salinity") */
    public static final String PROP_salinity    = "salinity";
    
    /** Number of attributes defined by this class (including typeName) */
    public static final int numNewAttributes = 5;
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

    /** 
     * Assigns the life stage type name to the constructed subclass instance and adds
     * the attribute keys and information defined in this class to the static Set "keys" 
     * and the static Map mapAttributes.
     * 
     * Subclasses should call this constructor with a valid life stage type name from
     * all constructors to set the type name.  They should then 
     * 
     *@param typeName - the type name as a String.
     */
    protected AbstractArrowtoothAttributes(String typeName) {
        super(typeName);
        finishInstantiation();
    }

    private void finishInstantiation(){
        if (newKeys.isEmpty()){
            //set static field information
            mapAttributes.putAll(AbstractLHSAttributes.mapAttributes);//add from superclass
            keys.addAll(AbstractLHSAttributes.keys);//add from superclass
            String key;
            key = PROP_attached;   newKeys.add(key); mapAttributes.put(key,new IBMAttributeBoolean(key,"attached"));
            key = PROP_size;       newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"size"));
            key = PROP_weight;     newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"weight"));
            key = PROP_temperature;newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"temperature"));
            key = PROP_salinity;   newKeys.add(key); mapAttributes.put(key,new IBMAttributeDouble(key,"salinity"));
            keys.addAll(newKeys);//add new keys from this class
            Iterator<String> it = keys.iterator();
            int j = 0; it.next();//skip typeName
            while (it.hasNext()) aKeys[j++] = it.next();
        }
        //set instance information
        Map<String,Object> tmpMapValues = new HashMap<>((int)(2*numAttributes));
        tmpMapValues.putAll(mapValues);//copy from super
        tmpMapValues.put(PROP_attached,   new Boolean(true));
        tmpMapValues.put(PROP_size,       new Double(0));
        tmpMapValues.put(PROP_weight,     new Double(0));
        tmpMapValues.put(PROP_temperature,new Double(-1));
        tmpMapValues.put(PROP_salinity,   new Double(-1));
        mapValues = tmpMapValues;//assign to super
    }

    /**
     *  This method should be overridden by extending classes.
     */
    @Override
    public abstract LifeStageAttributesInterface createInstance(final String[] strv);

    /**
     *  This method should be overridden by extending classes.
     */
    @Override
    public abstract Object clone() throws CloneNotSupportedException;
    
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
     * Returns Class types for all attributes (including typeName) as a Class[]
 in the order the keys are defined.
     * 
     * @return 
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
     * Returns short names for all attributes (including typeName) as a String[]
 in the order the keys are defined.
     * 
     * @return 
     */
    @Override
    public String[] getShortNames() {
        if (shortNames[0]==null){
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
            String[] aKeys = new String[keys.size()];
            aKeys = keys.toArray(aKeys);
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
            String[] aKeys = new String[keys.size()];
            aKeys = keys.toArray(aKeys);
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

    /**
     * Gets type name and attribute values as an ArrayList.  Subclasses should 
     * override this method. The overriding method can call super.getArrayList()
     * to return an ArrayList of the correct size and with the values filled in
     * for the attributes defined in this class.
     * 
     * @return - the array list.
     */
    @Override
    public ArrayList getArrayList() {
        ArrayList a = super.getArrayList();
        for (String key: newKeys) a.add(getValue(key));
        return a;
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
     * Returns the value, as a string, of the attribute associated with a key.
     * 
     * @param key - String associated with the attribute of interest
     * @return - the value, as a string, of the attribute associated with the key
     */
    @Override
    public String getValueAsString(String key){
        Object val = getValue(key);
        IBMAttribute att = mapAttributes.get(key);
        att.setValue(val);
        String str = att.getValueAsString();
        return str;
    }
    
    /**
     * Sets the value, from a string, of the attribute associated with a key.
     * 
     * @param key - String associated with the attribute of interest
     * @param value - the value, as a string, for the attribute associated with the key
     */
    @Override
    public void setValueFromString(String key, String value) throws NumberFormatException {
        if (!key.equals(PROP_typeName)){
            IBMAttribute att = mapAttributes.get(key);
            att.parseValue(value);
            setValue(key,att.getValue());
        }
    }
}
