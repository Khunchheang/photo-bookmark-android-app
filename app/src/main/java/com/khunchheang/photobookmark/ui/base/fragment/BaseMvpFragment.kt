package com.khunchheang.photobookmark.ui.base.fragment

import com.khunchheang.photobookmark.R
import com.khunchheang.photobookmark.ui.base.basemvp.BaseMvpView
import com.khunchheang.photobookmark.ui.dialog.LoadingDialog

abstract class BaseMvpFragment : BaseFragment(), BaseMvpView {

    internal var loading: LoadingDialog? = null

    override fun showError(msg: String) {
        hideLoading()
        showToast(msg)
    }

    override fun showError(msg: Int) {
        showToast(getString(msg))
    }

    override fun showException(msg: String) {
        hideLoading()
        showToast(msg)
    }

    override fun showLoading() {
        if (loading == null) loading = LoadingDialog.newInstance()
        loading?.show(fragmentManager!!, getString(R.string.loading))
    }

    override fun hideLoading() {
        loading?.dismiss()
        loading = null
    }

    override fun onServerDown(msg: Int) {
        showDialogMessage(getString(msg))
            .setTitle(getString(R.string.problem_occur))
            .show(true)
    }

    override fun onUnauthorized(msg: Int) {
        showDialogMessage(getString(msg))
            .setTitle(getString(R.string.problem_occur))
            .setTextButtonPositive(getString(R.string.ok))
            .show(false)
    }
}