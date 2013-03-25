package models.functionality;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.*;
import play.data.validation.*;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * See SCL IEC 61850, CIMOM for examples
 */
public class Functionality extends Model {
    @Id
//    @GeneratedValue(generator = "system-uuid")    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public UUID id;
    @Constraints.Required
    @ManyToMany(cascade = CascadeType.ALL)
    public Collection<EdgeType> validInTypes;
    @ManyToMany(cascade = CascadeType.ALL)
    public Collection<EdgeType> validOutTypes;
    public String name;
    @ManyToMany(cascade = CascadeType.ALL)
    public Collection<FunctionalityField> assetAttributes;
    
    public Iterable<Functionality> getValidInFunctionality(EdgeType edgeType) {
        return null; 
        //TODO query functionality for those with validInTypes of edgeType
    }
    public Iterable<Functionality> getValidOutFunctionality(EdgeType edgeType) {
        return null;
        //TODO query functionality for those with validInTypes of edgeType
    }
}
