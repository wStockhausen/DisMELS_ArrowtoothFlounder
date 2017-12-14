/*
 * BenthicJuvenileStageAttributes.java
 */

package wts.models.DisMELS.IBMs.ArrowtoothFlounder.BenthicJuvenile;

import java.util.*;
import java.util.logging.Logger;
import org.openide.util.lookup.ServiceProvider;
import wts.models.DisMELS.IBMs.ArrowtoothFlounder.AbstractArrowtoothAttributes;
import wts.models.DisMELS.framework.IBMAttributes.IBMAttribute;
import wts.models.DisMELS.framework.IBMAttributes.IBMAttributeBoolean;
import wts.models.DisMELS.framework.IBMAttributes.IBMAttributeDouble;

/**
 * DisMELS class representing attributes for arrowtooth flounder benthic juveniles.
 */
@ServiceProvider(service=wts.models.DisMELS.framework.LifeStageAttributesInterface.class)
public class BenthicJuvenileStageAttributes extends AbstractArrowtoothAttributes {
    
    /** logger for debugging messages */
    private static final Logger logger = Logger.getLogger(BenthicJuvenileStageAttributes.class.getName());
    
    /**
     * This constructor is provided only to facilitate the ServiceProvider functionality.
     * DO NOT USE IT!!
     */
    public BenthicJuvenileStageAttributes(){
        super("NULL");
    }
    
    /**
     * Creates a new attributes instance with type name 'typeName'.
     */
    public BenthicJuvenileStageAttributes(String typeName) {
        super(typeName);
    }
    
    /**
     * Returns a deep copy of the instance.  Values are copied.  
     * Any listeners on 'this' are not(?) copied, so these need to be hooked up.
     * @return - the clone.
     */
    @Override
    public Object clone() {
        BenthicJuvenileStageAttributes clone = new BenthicJuvenileStageAttributes(typeName);
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
    public BenthicJuvenileStageAttributes createInstance(final String[] strv) {
        BenthicJuvenileStageAttributes atts = new BenthicJuvenileStageAttributes(strv[0]);//this sets atts.typeName
        atts.setValues(strv);
        return atts;
    }    
}
