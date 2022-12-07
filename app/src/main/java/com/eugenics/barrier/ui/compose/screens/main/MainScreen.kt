package com.eugenics.barrier.ui.compose.screens.main

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import com.eugenics.barrier.domain.model.PhoneRecord
import com.eugenics.barrier.ui.compose.screens.main.components.RecordRow
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionRequired
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen(
    records: StateFlow<List<PhoneRecord>> = MutableStateFlow(listOf()),
    getRecords: () -> Unit,
) {
    LaunchedEffect(null) {
        getRecords()
    }

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
        content = { MainContent(records = records) }
    )
}

@Composable
private fun MainContent(
    records: StateFlow<List<PhoneRecord>> = MutableStateFlow(listOf())
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        val lazyListState = rememberLazyListState()
        val context = LocalContext.current
        val phoneRecords = records.collectAsState()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = lazyListState
        ) {
            items(
                items = phoneRecords.value,
                key = { record -> record.id }
            ) { phoneRecord ->
                RecordRow(
                    titleText = phoneRecord.name,
                    subTitleText = phoneRecord.phoneNumber,
                    onClick = {
                        val intent = Intent(
                            Intent.ACTION_CALL,
                            "tel:${phoneRecord.phoneNumber}".toUri()
                        )
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
private fun Rationale(
    onRequestPermission: () -> Unit
) {
    val rationale = "Эти разрешения очень важны для приложения."

    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = "Запрос разрешений")
        },
        text = {
            Text(rationale)
        },
        confirmButton = {
            Button(onClick = onRequestPermission) {
                Text("OK")
            }
        }
    )
}