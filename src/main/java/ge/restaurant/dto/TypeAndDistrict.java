package ge.restaurant.dto;

import java.util.Set;

public class TypeAndDistrict {
    private Set<String> types;

    private Set<String> district;

    public TypeAndDistrict() {
    }

    public TypeAndDistrict(Set<String> types, Set<String> district) {
        this.types = types;
        this.district = district;
    }

    public Set<String> getTypes() {
        return types;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }

    public Set<String> getDistrict() {
        return district;
    }

    public void setDistrict(Set<String> district) {
        this.district = district;
    }
}
