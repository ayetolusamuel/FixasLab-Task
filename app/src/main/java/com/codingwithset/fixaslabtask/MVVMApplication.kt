package com.codingwithset.fixaslabtask

import android.app.Application
import com.codingwithset.fixaslabtask.database.AppDatabase
import com.codingwithset.fixaslabtask.network.MyApi
import com.codingwithset.fixaslabtask.network.NetworkConnectionInterceptor
import com.codingwithset.fixaslabtask.repository.DataRepository
import com.codingwithset.fixaslabtask.viewmodel.DataViewModelFactory
import com.facebook.stetho.Stetho
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class MVVMApplication : Application(), KodeinAware {


    override val kodein = Kodein.lazy {

        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { DataRepository(instance(), instance()) }
        bind() from provider {
            DataViewModelFactory(
                instance()
            )
        }

    }


    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

    }

}