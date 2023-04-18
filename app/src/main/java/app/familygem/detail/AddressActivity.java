package app.familygem.detail;

import org.folg.gedcom.model.Address;

import app.familygem.DetailActivity;
import app.familygem.Memory;
import app.familygem.R;
import app.familygem.util.ChangeUtils;

public class AddressActivity extends DetailActivity {

    Address a;

    @Override
    public void format() {
        setTitle(R.string.address);
        placeSlug("ADDR");
        a = (Address)cast(Address.class);
        place(getString(R.string.value), "Value", false, true); // Deprecated by GEDCOM standard in favor of the fragmented address
        place(getString(R.string.name), "Name", false, false); // '_NAME' tag not GEDCOM standard
        place(getString(R.string.line_1), "AddressLine1");
        place(getString(R.string.line_2), "AddressLine2");
        place(getString(R.string.line_3), "AddressLine3");
        place(getString(R.string.postal_code), "PostalCode");
        place(getString(R.string.city), "City");
        place(getString(R.string.state), "State");
        place(getString(R.string.country), "Country");
        placeExtensions(a);
    }

    @Override
    public void delete() {
        deleteAddress(Memory.getSecondToLastObject());
        ChangeUtils.INSTANCE.updateChangeDate(Memory.getLeaderObject());
        Memory.setInstanceAndAllSubsequentToNull(a);
    }
}
