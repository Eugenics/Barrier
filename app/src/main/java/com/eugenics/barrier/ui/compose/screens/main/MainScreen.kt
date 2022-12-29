package com.eugenics.barrier.ui.compose.screens.main

import androidx.compose.runtime.Composable
import com.eugenics.barrier.domain.model.PhoneRecord
import com.eugenics.barrier.ui.compose.screens.main.components.MainContent
import com.eugenics.barrier.ui.compose.screens.main.components.Rationale
import com.eugenics.barrier.ui.util.UiState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionRequired
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen(
    uiState: UiState = UiState.Loading,
    setUiState: (uiState: UiState) -> Unit = { _ -> },
    records: List<PhoneRecord>,
    onRecordEdit: (record: PhoneRecord) -> Unit = { _ -> },
    onRecordDelete: (record: PhoneRecord) -> Unit = { _ -> }
) {
    val permission = android.Manifest.permission.CALL_PHONE
    val permissionState = rememberPermissionState(permission)

    PermissionRequired(
        permissionState = permissionState,
        permissionNotAvailableContent = {},
        permissionNotGrantedContent = {
            Rationale(
                onRequestPermission = { permissionState.launchPermissionRequest() }
            )
        },
        content = {
            MainContent(
                records = records,
                uiState = uiState,
                setUiState = setUiState,
                onRecordEdit = onRecordEdit,
                onRecordDelete = onRecordDelete
            )
        }
    )
}