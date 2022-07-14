package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public enum TipoUsuario {
    Administrador(1), Cliente(2);
    
    private final int tipo;

    private TipoUsuario(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public static TipoUsuario of(int tipo) {
        return Stream.of(TipoUsuario.values())
          .filter(p -> p.getTipo() == tipo)
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
    
    //Configurando transformação JSON
    private static final Map<String, TipoUsuario> namesMap = new HashMap<>(2);

    static {
        namesMap.put("administrador", Administrador);
        namesMap.put("cliente", Cliente);
    }

    @JsonCreator
    public static TipoUsuario forValue(String value) {
        return namesMap.get(value.toLowerCase());
    }

    @JsonValue
    public String toValue() {
        for (Entry<String, TipoUsuario> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }
        return null;
    }
    
}
