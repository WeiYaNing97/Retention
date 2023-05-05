import request from '@/utils/request'

// 查询消息测试列表
export function listTestMessage(query) {
  return request({
    url: '/test/testMessage/list',
    method: 'get',
    params: query
  })
}

// 查询消息测试详细
export function getTestMessage(id) {
  return request({
    url: '/test/testMessage/' + id,
    method: 'get'
  })
}

// 新增消息测试
export function addTestMessage(data) {
  return request({
    url: '/test/testMessage',
    method: 'post',
    data: data
  })
}

// 修改消息测试
export function updateTestMessage(data) {
  return request({
    url: '/test/testMessage',
    method: 'put',
    data: data
  })
}

// 删除消息测试
export function delTestMessage(id) {
  return request({
    url: '/test/testMessage/' + id,
    method: 'delete'
  })
}
