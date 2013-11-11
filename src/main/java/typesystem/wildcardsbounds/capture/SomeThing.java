package typesystem.wildcardsbounds.capture;

import java.util.Set;

interface SomeThing<T> {
	T createThing();

	void doSomething(T one, T other);

	Set<T> getThings();
}
