package models;
import java.util.LinkedHashMap;
import java.util.Map;

import play.Logger;
import play.Play;

import com.tinkerpop.blueprints.*;

import com.orientechnologies.orient.core.db.graph.OGraphDatabase;
import com.orientechnologies.orient.core.id.ORecordId;
import com.orientechnologies.orient.core.intent.OIntentMassiveInsert;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLQuery;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

public class Part implements Comparable<Part> {
    private final ORecordId id;
    private static final String RID = "@rid";
    private final Map<String, Object> attributes;

    private static String getDBUser() {
        return Play.application().configuration().getString("orientdb.user", "admin");
    }

    private static String getGraphDBPassword() {
        return Play.application().configuration().getString("orientdb.password", "admin");
    }

    private static String getDBUrl() {
        return Play.application().configuration().getString("orientdb.url", "remote:localhost/testdata");
    }

    @Override
    public int compareTo(Part arg0) {
        // TODO Auto-generated method stub
        return 0;
    }
    private ORecordId getId(final ODocument document) {
        ORecordId result;
        final Object documentId = (document == null) ?  null : document.getIdentity();
        if (documentId == null) {
          result = null;
        } else {
          result = (documentId instanceof ORecordId) ? (ORecordId)documentId : null;
        }
        return result;
      }
    /**
     * Create an Asset, not persisted to the database
     * 
     * @param vertex
     */
    private Part(final ODocument vertex) {
      id = getId(vertex);
      attributes = new LinkedHashMap();
      for (String fieldName : vertex.fieldNames()) {
        final Object fieldValue = vertex.field(fieldName);
        if (!(RID.equals(fieldName) || "out".equals(fieldName) || "in".equals(fieldName))) {
          attributes.put(fieldName, fieldValue);
        }
      }
    }
}
