package ma.project.metier;

import java.util.Date;

public interface IAbstarct {
    Long getId();

    void setDeleteDate(Date deleteDate);

    Date getDeleteDate();

    void setUpdateDate(Date updateDate);

}
