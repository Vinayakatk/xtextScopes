/**
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl;

import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.xtext.example.mydsl.AbstractMyDslRuntimeModule;
import org.xtext.example.mydsl.MyDslGlobalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class MyDslRuntimeModule extends AbstractMyDslRuntimeModule {
  @Override
  public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
    return MyDslGlobalScopeProvider.class;
  }
}