
package annotation;

import java.lang.annotation.*;

@Documented // in javadoc
@Inherited
@Target(ElementType.METHOD) // CONSTRUCTOR FILED LOCAL_VARIABLE METHOD PACKAGE PARAMETER TYPE
@Retention(RetentionPolicy.RUNTIME) // SOURCE CLASS RUNTIME

public @interface Test {
}

@interface SQLType {
	int inn() default 0;
}

@interface TableColumn {
	SQLType SQLType() default @SQLType;
}
